package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.FloorService;
import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.dto.AddLibraryDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddPlayGroundDto;
import com.mobileapplication.app.classroom.service.dto.AddRestDto;
import com.mobileapplication.app.classroom.service.dto.AddRestRoomDto;
import com.mobileapplication.app.classroom.service.dto.AddSportDto;
import com.mobileapplication.app.classroom.service.dto.AddStaffRoomDto;
import com.mobileapplication.app.classroom.service.dto.AddStandardRequestDetailsDto;
import com.mobileapplication.app.classroom.service.entity.FloorEntity;
import com.mobileapplication.app.classroom.service.entity.LibraryEntity;
import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;
import com.mobileapplication.app.classroom.service.entity.PlayGroundEntity;
import com.mobileapplication.app.classroom.service.entity.RestEntity;
import com.mobileapplication.app.classroom.service.entity.RestRoomEntity;
import com.mobileapplication.app.classroom.service.entity.SportEntity;
import com.mobileapplication.app.classroom.service.entity.StaffRoomEntity;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.repository.FloorRepository;
import com.mobileapplication.app.classroom.service.repository.LibraryRepository;
import com.mobileapplication.app.classroom.service.repository.OrganizationRepository;
import com.mobileapplication.app.classroom.service.repository.PlayGroundRepository;
import com.mobileapplication.app.classroom.service.repository.RestRepository;
import com.mobileapplication.app.classroom.service.repository.RestRoomRepository;
import com.mobileapplication.app.classroom.service.repository.SportRepository;
import com.mobileapplication.app.classroom.service.repository.StaffRoomRepository;
import com.mobileapplication.app.classroom.service.repository.StandardRepository;
import com.mobileapplication.app.classroom.service.repository.TeacherRepository;
import com.mobileapplication.app.classroom.service.shared.Utils;

@Service
public class OrganizationServiceimpl implements OrganizationService {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Autowired
	StandardRepository standardRepository;
	
	@Autowired
	FloorRepository floorRepository;
	
	@Autowired
	RestRoomRepository restRoomRepository;
	
	@Autowired
	RestRepository restRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	StaffRoomRepository staffRoomRepository;
	
	@Autowired
	PlayGroundRepository playGroundRepository;
	
	@Autowired
	SportRepository sportRepository;
	
	@Autowired
	FloorService floorService;
	
	@Autowired
	Utils utils;
	
	@Override
	public OrganizationEntity addInOrganization(StudentEntity studentDetails) {
		
		OrganizationEntity returnValue = new OrganizationEntity();
		
		List<StudentEntity> students = new ArrayList<>();
		
		students.add(studentDetails);
		
		String name = studentDetails.getOrganization();
		
		OrganizationEntity found = organizationRepository.findOrganizationByName(name);
		
		if(found==null) {
			found = new OrganizationEntity();
			found.setName(name);
			found.setOrganizationId(utils.GenerateOrganizationId(20));
			found.setStudentDetails(students);
		}
		else {
			found.setStudentDetails(students);
		}
		
		OrganizationEntity saved = organizationRepository.save(found);
		
		returnValue = saved;
		
		
		return returnValue;
		
		
	}


	@Override
	public OrganizationEntity addTeacherInOrganization(TeacherEntity entity) {
		OrganizationEntity returnValue = new OrganizationEntity();
		
		if(entity==null)
			return returnValue;
		
		//Hello
		
		List<TeacherEntity> teachers = new ArrayList<>();
		teachers.add(entity);
		
		String name = entity.getOrganization();
		
		OrganizationEntity organization =  organizationRepository.findOrganizationByName(name);
		
		
		if(organization==null) {
			organization = new OrganizationEntity();
			organization.setName(name);
			organization.setOrganizationId(utils.GenerateOrganizationId(20));
			organization.setTeacherDetails(teachers);
		}
		else {
			teachers = organization.getTeacherDetails();
			teachers.add(entity);
			organization.setTeacherDetails(teachers);
		}
		
		returnValue = organizationRepository.save(organization);
		
		return returnValue;
	}


	@Override
	public boolean addLibrary(String organizationId, AddLibraryDetailsDto addLibraryDetailsDto) {
		
		OrganizationEntity organization = organizationRepository.findOrganizationByOrganizationId(organizationId);
		
		if(organization==null)
			throw new RuntimeException("Organization DoesNot Exist");
		
		if(organization.isHasLibrary())
			throw new RuntimeException("Organization "+organization.getName()+" already has a library");
		
		
		//we are just adding the library not the book -> so need to add book details now
		
		LibraryEntity library = mapper.map(addLibraryDetailsDto,LibraryEntity.class);
		
		library.setLibraryId(utils.GenerateLibraryId(5));
		
		library.setOrganizationDetails(organization);
		
		LibraryEntity saved = libraryRepository.save(library);
		
		organization.setLibraryDetails(saved);
		organization.setHasLibrary(true);
		
		return organizationRepository.save(organization)!=null;
		
	}


	@Override
	public void addStandard(String organizationId, AddStandardRequestDetailsDto addStandardRequestDetailsDto) {
		// TODO Auto-generated method stub
		
		OrganizationEntity organization = organizationRepository.findOrganizationByOrganizationId(organizationId);
		
		if(organization==null)
			throw new RuntimeException("Organization Does not Exist");
		
		//If standard exist -> Just update the strength Else create New Standard
		
		List<StandardEntity> standards = standardRepository.findStandardsByStandardNameAndSection(addStandardRequestDetailsDto.getStandard(), addStandardRequestDetailsDto.getSection());
		
		
		if(standards.size()==0) {
			StandardEntity standard = new StandardEntity();
			standard.setStandardName(addStandardRequestDetailsDto.getStandard());
			standard.setSection(addStandardRequestDetailsDto.getSection());
			
			int num = utils.getFloorNumber(addStandardRequestDetailsDto.getStandard(), addStandardRequestDetailsDto.getSection());
			
			FloorEntity floorEntity = floorRepository.findFloorByFloorNumber(num);
			
			if(floorEntity == null) {
				floorEntity = floorService.setFloorDetails(addStandardRequestDetailsDto);
			}
			
			
			standard.setFloorDetails(floorEntity);
			
			StandardEntity savedStandard = standardRepository.save(standard);
			
			
			if(floorEntity.getStandardDetails()==null) {
				List<StandardEntity> standard_s = new ArrayList<>();
				standard_s.add(savedStandard);
				floorEntity.setStandardDetails(standard_s);
			}
			else {
				List<StandardEntity> standard_s = floorEntity.getStandardDetails();
				standard_s.add(savedStandard);
				floorEntity.setStandardDetails(standard_s);
			}
			
			floorRepository.save(floorEntity);
			
			
		}
		else {
			for(StandardEntity standard:standards) {
				
				standard.setStrength(addStandardRequestDetailsDto.getStrength());
				
				if(standard.getFloorDetails()==null) {
					
					FloorEntity entity = floorRepository.findFloorByFloorNumber(utils.getFloorNumber(addStandardRequestDetailsDto.getStandard(), addStandardRequestDetailsDto.getSection()));
					
					if(entity == null)
						entity = floorService.setFloorDetails(addStandardRequestDetailsDto);
					

					standard.setFloorDetails(entity);
					
					StandardEntity savedEntity = standardRepository.save(standard);
					
					
					if(entity.getStandardDetails()==null) {
						List<StandardEntity> standard_s = new ArrayList<>();
						standard_s.add(savedEntity);
						entity.setStandardDetails(standard_s);
					}
					else {
						List<StandardEntity> standard_s =  entity.getStandardDetails();
						standard_s.add(savedEntity);
						entity.setStandardDetails(standard_s);
					}
					
					
					
					floorRepository.save(entity);
				}
				else {
					
					StandardEntity savedEntity = standardRepository.save(standard);
					
					FloorEntity entity = savedEntity.getFloorDetails();
					
					List<StandardEntity> standard_s = entity.getStandardDetails();
					standard_s.add(standard);
					entity.setStandardDetails(standard_s);
					
					floorRepository.save(entity);
				}
			}
		}
		
		
		
	}


	@Override
	public RestRoomEntity addRestRooms(String organizationId, String floorId, AddRestRoomDto addRestRoomDto) {
		
		//User Entered values
		
		List<AddRestDto> addRestDto = addRestRoomDto.getRestDetails();
		
		for(int i=0;i<addRestDto.size();i++) {
			AddRestDto rest = addRestDto.get(i);
			
			rest.setRestId(utils.GenerateFloorId(5));
			rest.setRestRoomDetails(addRestRoomDto);
			
			addRestDto.set(i, rest);
		}
		
		addRestRoomDto.setRestDetails(addRestDto);
		
		//Continued
		
		OrganizationEntity organization = organizationRepository.findOrganizationByOrganizationId(organizationId);
		
		FloorEntity floor = floorRepository.findFloorByFloorId(floorId);
		
		if(organization==null)
			throw new RuntimeException("Organization With Given Id Doesnot Exist");
		
		if(floor==null)
			throw new RuntimeException("Floor With Given Id Doesnot Exist");
		
		if(floor!=null && floor.getRestRoomDetails()!=null) {
			List<String> enteredType = new ArrayList<>();
			List<AddRestDto> rests = addRestRoomDto.getRestDetails();
			
			for(AddRestDto rest:rests) {
				enteredType.add(rest.getType());
			}
			
			RestRoomEntity entity = floor.getRestRoomDetails();
			
			List<RestEntity> restEntity = entity.getRestDetails();
			
			for(RestEntity rest:restEntity) {
				if(enteredType.contains(rest.getType()))
					throw new RuntimeException("Floor Already Has A Rest Room");
			}
			
			
		}
		
		
		RestRoomEntity restRoomEntity = mapper.map(addRestRoomDto,RestRoomEntity.class);
		
		if(floor.getRestRoomDetails()==null) {
		
			restRoomEntity.setRestRoomId(utils.GenerateFloorId(7));
			restRoomEntity.setHasRestRoom(true);
			restRoomEntity.setOrganizationDetails(organization);
			restRoomEntity.setFloorDetails(floor);
			
			RestRoomEntity saved = restRoomRepository.save(restRoomEntity);
			
			floor.setRestRoomDetails(saved);
			
			if(organization.getRestRoomDetails()==null) {
				List<RestRoomEntity> restRooms = new ArrayList<RestRoomEntity>();
				restRooms.add(saved);
				organization.setRestRoomDetails(restRooms);
			}
			else {
				List<RestRoomEntity> restRooms = organization.getRestRoomDetails();
				restRooms.add(saved);
				organization.setRestRoomDetails(restRooms);
			}
			
			organizationRepository.save(organization);

			return saved;
		}
		else {
			
			RestRoomEntity alreadyPresent = floor.getRestRoomDetails();
			
			List<RestEntity> alreadyPresentRests = alreadyPresent.getRestDetails();
			
			List<RestEntity> addedRest = restRoomEntity.getRestDetails();
			
			for(int i=0;i<addedRest.size();i++)
				addedRest.get(i).setRestRoomDetails(alreadyPresent);
			
			
			for(int i=0;i<addedRest.size();i++) {
				boolean flag = false;
				for(int j=0;j<alreadyPresentRests.size();j++) {
					
					if(addedRest.get(i).getType().equalsIgnoreCase(alreadyPresentRests.get(j).getType())) {
						alreadyPresentRests.set(j, addedRest.get(i));
						flag = true;
						break;
					}
					
				}
				if(!flag)
					alreadyPresentRests.add(addedRest.get(i));
			}
			
			alreadyPresent.setRestDetails(alreadyPresentRests);
			
			RestRoomEntity saved = restRoomRepository.save(alreadyPresent);
			
			floor.setRestRoomDetails(saved);
			floorRepository.save(floor);
			
			List<RestRoomEntity> entity =  organization.getRestRoomDetails();
			
			for(int i=0;i<entity.size();i++) {
				RestRoomEntity rest = entity.get(i);
				
				if(rest.getRestRoomId().equalsIgnoreCase(saved.getRestRoomId())) {
					entity.set(i, saved);
					break;
				}
				
			}
			organization.setRestRoomDetails(entity);
			
			organizationRepository.save(organization);
			
			return saved;
			
		}
		
		
	}


	@Override
	public StaffRoomEntity addStaffRoom(String organizationId,String floorId,AddStaffRoomDto staffRoomDto) {
		
		OrganizationEntity organization = organizationRepository.findOrganizationByOrganizationId(organizationId);
		
		FloorEntity floor = floorRepository.findFloorByFloorId(floorId);
		
		if(organization==null)
			throw new RuntimeException("Organization with current ID doesnot exist");
		
		if(floor==null)
			throw new RuntimeException("Floor with current ID doesnot exist");
		
		if(floor!=null && floor.getStaffRoomDetails()!=null)
			if(floor.getStaffRoomDetails().isHasStaffRoom())
				throw new RuntimeException("Staff room on that floor already Exists");
		
		StaffRoomEntity staffRoom = mapper.map(staffRoomDto,StaffRoomEntity.class);
		
		staffRoom.setStaffRoomId(utils.GenerateOrganizationId(10));
		staffRoom.setName(floor.getFloorName()+" Staff Room");
		staffRoom.setHasStaffRoom(true);
		staffRoom.setOrganizationDetails(organization);
		staffRoom.setFloorDetails(floor);
		
		List<TeacherEntity> teachersOnFloor = floorService.getTeachersOnFloor(floor);
		
		staffRoom.setTeacherDetails(teachersOnFloor);
		staffRoom.setCapacity(teachersOnFloor.size()+10);
		
		StaffRoomEntity saved = staffRoomRepository.save(staffRoom);
		
		
		floor.setStaffRoomDetails(saved);
		floorRepository.save(floor);
		
		if(organization.getStaffRoomDetails()==null) {
			List<StaffRoomEntity> entity = new ArrayList<>();
			entity.add(saved);
			organization.setStaffRoomDetails(entity);
		}
		else {
			List<StaffRoomEntity> entity = organization.getStaffRoomDetails();
			entity.add(saved);
			organization.setStaffRoomDetails(entity);
		}
		organizationRepository.save(organization);
		
		for(TeacherEntity entity:teachersOnFloor) {
			entity.setStaffRoomDetails(saved);
			teacherRepository.save(entity);
		}
		
		return saved;
		
	}


	@Override
	public PlayGroundEntity addPlayGround(String organizationId, AddPlayGroundDto addPlayGroundDto) {
		
		List<AddSportDto> sportDto =  addPlayGroundDto.getSportDetails();
		
		for(int i=0;i<sportDto.size();i++) {
			AddSportDto sport = sportDto.get(i);
			
			sport.setSportId(utils.GenerateOrganizationId(5));
			sport.setPlayGroundDetails(addPlayGroundDto);
			
			sportDto.set(i, sport);
		}
		
		addPlayGroundDto.setSportDetails(sportDto);
		
		OrganizationEntity organization = organizationRepository.findOrganizationByOrganizationId(organizationId);
		
		if(organization == null)
			throw new RuntimeException("The Organization DoesNot Exist");
		
		if(organization.getTeacherDetails()==null)
			throw new RuntimeException("No Teachers In The Organization");
		
		List<TeacherEntity> allTeachers = organization.getTeacherDetails();
		
		List<TeacherEntity> sportsTeachers = new ArrayList<>();
		
		for(TeacherEntity teacher:allTeachers) {
			if(teacher.getRole().equalsIgnoreCase("PT") || teacher.getRole().equalsIgnoreCase("PE") || teacher.getRole().equalsIgnoreCase("PTE"))
				sportsTeachers.add(teacher);
		}
		
		if(sportsTeachers.size() == 0)
			throw new RuntimeException("No Sports Teacher In The Organization");
		
		PlayGroundEntity playGround = mapper.map(addPlayGroundDto,PlayGroundEntity.class);
		
		playGround.setPlayGroundId(utils.GenerateOrganizationId(10));
		playGround.setOrganizationDetails(organization);
		
		List<SportEntity> sports = playGround.getSportDetails();
		
		for(SportEntity sport:sports)
			sport.setHasGround(true);
		
		playGround.setSportDetails(sports);
		
		playGround.setTeacherDetails(sportsTeachers);
		
		PlayGroundEntity saved = playGroundRepository.save(playGround);
		
		
		if(organization.getPlayGroundDetails()==null) {
			List<PlayGroundEntity> playGrounds = new ArrayList<>();
			playGrounds.add(saved);
			organization.setPlayGroundDetails(playGrounds);
		}
		else {
			List<PlayGroundEntity> playGrounds = organization.getPlayGroundDetails();
			playGrounds.add(saved);
			organization.setPlayGroundDetails(playGrounds);
		}
		organizationRepository.save(organization);
		
		
		for(TeacherEntity teacher:sportsTeachers) {
			
			if(teacher.getPlayGroundDetails() == null) {
				List<PlayGroundEntity> playGrounds = new ArrayList<>();
				playGrounds.add(saved);
				teacher.setPlayGroundDetails(playGrounds);
			}
			else {
				List<PlayGroundEntity> playGrounds = teacher.getPlayGroundDetails();
				playGrounds.add(saved);
				teacher.setPlayGroundDetails(playGrounds);
			}
			
			teacherRepository.save(teacher);
		}
		
		
		return saved;
		
	}

}
