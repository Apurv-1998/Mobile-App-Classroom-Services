package com.mobileapplication.app.classroom.service.shared;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobileapplication.app.classroom.service.entity.SessionDetailsEntity;
import com.mobileapplication.app.classroom.service.entity.SessionsEntity;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.StudentScoresEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.response.model.SessionsRest;

@Component
public class Utils {
	
	@Autowired
	ModelMapper mapper;

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final String PASSWORD_SALT = "jbndugweufdhg48ryhnwqed98h89&R%^ER^&TEW*(Y*Guiiuqgw7ftgog3uidhyh2&%T^&%T&*YT*EYHIUHDIUte87edhuiY*&T^&*Y*&&*Y*&D78eytdyb8bfy83yb3";
	private final String REG_SALT = "DHCJIUWEHFUWHFUJHOIJIOWHEFHY489RU3498F984YF8734YF89H934HC74HFIFUIHOHIFUH19838HFH^*&%^$#%^&#$&*^)(()hgjhcy";
	private final String SUBJECT_SALT = "mathsenglishphysicschemistrybiologyhindisciencehistorycivisgeographysocialstudiessocialscienceenvironmentsciencephysicaleducationcomputerscommerce";
	private final String TEST_SALT = "classtestunittestsuprisetestmidtermtestendtermtesthalfyearlyfinalspreboardboardhomeboardquarterlytestsoraltexts";
	private final String FILE_SALT = "sbdufgb38e4trf7843dhu1hd87913ghfbhho19837yghrf981hyu398dhf891yf89h1093hjd9j1980nhbv8hf98h1893yhf98y3h1498fh19834hf9834g4hf98h98yh3489fyIOXJ98QEY4F8HY2983H4F983H984FH981Hiy";
	private final String SESSIONS_SALT = "ncoihq3hygft2yhpio43foi2h34h893467891q3hncgf7u21po348uhyrcb834huyxpmn34yr78yqohbnc8y438mxypqo398ytbcvy4IQUOHWE4BQPO";
	private final String SESSIONS_PASSWORD_SALT = "nw;peiurfqhriufhioqhloijfoiqjh43ut092u3q490fuj&(*^%^&^R^GFUH)(*&^%E$RSDFCGHVJBKL_{}P:?><m,./'[poijhgGDSERTYUIKMNBVCXCFGHJ";
	private final String SESSION_DETAILS_SALT = "NQEIOURHFIUQLHEIRUHFIOQHIOHIOQEYUFIOQHIOEHNCLQNERIHVIRBVWURPMXIUQIOEUJIOU94U790R8720943859047894YFJHQ";

	public String generateStudentId(int length) {
		return generatedStudentId(length);
	}

	public String generateEncryptedPassword(int length) {
		return generatedPassword(length);
	}

	public String GenerateOrganizationId(int length) {
		return generatedOrganizationId(length);
	}

	public String GenerateTeachersId(int length) {
		return generatedTeachersId(length);
	}

	public String GenerateEncryptedRegId(int length) {
		return generatedEncryptedRegId(length);
	}

	public String GenerateSubjectId(int length) {
		return generatedSubjectId(length);
	}

	public String GenerateTestId(int length) {
		return generatedTestId(length);
	}

	public String GenerateFileId(int length) {
		return generatedFilesId(length);
	}
	public String GenerateSessionsId(int length) {
		return generatedSessionsId(length);
	}
	public String GenerateSessionsPassword(int length) {
		return generatedSessionsPassword(length);
	}
	public String GenerateSessionDetailsId(int length) {
		return generatedSessionDetailsId(length);
	}

	
	
	private String generatedStudentId(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}

		return new String(sb);
	}

	private String generatedPassword(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(PASSWORD_SALT.charAt(RANDOM.nextInt(PASSWORD_SALT.length())));
		}

		return new String(sb);
	}

	private String generatedOrganizationId(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}

		return new String(sb);
	}

	private String generatedTeachersId(int length) {

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}

		return new String(sb);

	}

	private String generatedEncryptedRegId(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(REG_SALT.charAt(RANDOM.nextInt(REG_SALT.length())));
		}

		return new String(sb);
	}

	private String generatedSubjectId(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(SUBJECT_SALT.charAt(RANDOM.nextInt(SUBJECT_SALT.length())));
		}

		return new String(sb);
	}
	
	private String generatedTestId(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(TEST_SALT.charAt(RANDOM.nextInt(TEST_SALT.length())));
		}

		return new String(sb);
	}


	public List<String> GeneratedStandardsString(List<TeacherEntity> teachers) {
		List<String> list = new ArrayList<>();

		for (TeacherEntity teacher : teachers) {
			List<StandardEntity> standards = teacher.getStandard();
			for (StandardEntity standard : standards) {
				String s = standard.getStandardName() + " " + standard.getSection();
				list.add(s);
			}
		}

		return list;
	}

	public List<String> GeneratedAlreadyStandardsString(List<StandardEntity> currentStandards) {
		List<String> list = new ArrayList<>();

		for (StandardEntity entity : currentStandards) {
			String s = entity.getStandardName() + " " + entity.getSection();
			list.add(s);
		}

		return list;
	}

	public List<String> GeneratedStudentStandardsList(List<StudentEntity> students) {
		List<String> students_standards = new ArrayList<>();

		for (StudentEntity entity : students) {
			String s = entity.getStandard() + " " + entity.getSection();
			students_standards.add(s);
		}

		return students_standards;
	}

	public List<String> GeneratedTeacherStandardsString(List<StandardEntity> standards) {
		List<String> teachers_standards = new ArrayList<>();

		for (StandardEntity entity : standards) {
			String s = entity.getStandardName() + " " + entity.getSection();
			teachers_standards.add(s);
		}

		return teachers_standards;
	}

	public double FindAverageScore(List<StudentScoresEntity> studentScoresDetails) {
		
		double sum=0.0;
		
		for(int i=0;i<studentScoresDetails.size();i++)
			sum+=studentScoresDetails.get(i).getScore();
		
		return sum/(double)studentScoresDetails.size();
		
	}
	

	private String generatedFilesId(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(FILE_SALT.charAt(RANDOM.nextInt(FILE_SALT.length())));
		}

		return new String(sb);
	}
	
	private String generatedSessionsId(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(SESSIONS_SALT.charAt(RANDOM.nextInt(SESSIONS_SALT.length())));
		}

		return new String(sb);
	}
	
	private String generatedSessionsPassword(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(SESSIONS_PASSWORD_SALT.charAt(RANDOM.nextInt(SESSIONS_PASSWORD_SALT.length())));
		}

		return new String(sb);
	}
	
	private String generatedSessionDetailsId(int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(SESSION_DETAILS_SALT.charAt(RANDOM.nextInt(SESSION_DETAILS_SALT.length())));
		}

		return new String(sb);
	}

	public List<SessionsRest> getSessionsRestFromSessionDetails(SessionDetailsEntity session) {
		
		List<SessionsEntity> list = session.getSessions();
		
		List<SessionsRest> response = new ArrayList<>();
		
		for(SessionsEntity entity:list) {
			response.add(mapper.map(entity,SessionsRest.class));
		}
		
		return response;
	}

	public String ManageDate(long currentTimeMillis) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		
		Date returnValue = new Date(currentTimeMillis);
		
		return sdf.format(returnValue);
	}

}
