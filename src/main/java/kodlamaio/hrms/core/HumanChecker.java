package kodlamaio.hrms.core;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface HumanChecker {
    boolean isValid(JobSeeker jobSeeker);
}
