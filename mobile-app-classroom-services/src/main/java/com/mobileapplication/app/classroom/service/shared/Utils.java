package com.mobileapplication.app.classroom.service.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final String PASSWORD_SALT = "jbndugweufdhg48ryhnwqed98h89&R%^ER^&TEW*(Y*Guiiuqgw7ftgog3uidhyh2&%T^&%T&*YT*EYHIUHDIUte87edhuiY*&T^&*Y*&&*Y*&D78eytdyb8bfy83yb3";
	private final String REG_SALT = "DHCJIUWEHFUWHFUJHOIJIOWHEFHY489RU3498F984YF8734YF89H934HC74HFIFUIHOHIFUH19838HFH^*&%^$#%^&#$&*^)(()hgjhcy";
	private final String SUBJECT_SALT = "mathsenglishphysicschemistrybiologyhindisciencehistorycivisgeographysocialstudiessocialscienceenvironmentsciencephysicaleducationcomputerscommerce";

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
	
	
}
