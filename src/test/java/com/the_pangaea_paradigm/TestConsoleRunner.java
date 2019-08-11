package com.the_pangaea_paradigm;

import com.the_pangaea_paradigm.backend.communication.EMailWriterTest;
import com.the_pangaea_paradigm.backend.dao.IPFSProjectDaoTest;
import com.the_pangaea_paradigm.backend.dto.ApplicantTest;
import com.the_pangaea_paradigm.backend.dto.ProjectListTest;
import com.the_pangaea_paradigm.backend.dto.ProjectTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestConsoleRunner {

    public static void main(String[] args) {
        testConsoleRunner();
    }

    static void testConsoleRunner() {
        System.out.println("#################################");
        System.out.println("#        Starting Tests         #");
        System.out.println("#################################\n");
        System.out.println("Communication Tests:");
        System.out.println("#################################");
        Result r = JUnitCore.runClasses(EMailWriterTest.class);
        System.out.println("EMailWriter Tests: " + r.getRunCount() + " Tests completed in " + r.getRunTime() + "ms. "
                + r.getFailureCount() + " Failures.");
        if (r.getFailureCount() > 0) {
            for (Failure f : r.getFailures()) {
                System.out.println(f.getMessage());
            }
        }
        System.out.println("#################################\n");
        System.out.println("DAO Tests:");
        System.out.println("#################################");
        r = JUnitCore.runClasses(IPFSProjectDaoTest.class);
        System.out.println("IPFSProjectDao Tests: " + r.getRunCount() + " Tests completed in " + r.getRunTime() + "ms. "
                + r.getFailureCount() + " Failures.");
        if (r.getFailureCount() > 0) {
            for (Failure f : r.getFailures()) {
                System.out.println(f.getMessage());
            }
        }
        System.out.println("#################################\n");
        System.out.println("DTO Tests:");
        System.out.println("#################################");
        r = JUnitCore.runClasses(ProjectTest.class);
        System.out.println("Project Tests: " + r.getRunCount() + " Tests completed in " + r.getRunTime()
                + "ms. " + r.getFailureCount() + " Failures.");
        if (r.getFailureCount() > 0) {
            for (Failure f : r.getFailures()) {
                System.out.println(f.getMessage());
            }
        }
        r = JUnitCore.runClasses(ApplicantTest.class);
        System.out.println("Applicant Tests: " + r.getRunCount() + " Tests completed in " + r.getRunTime()
                + "ms. " + r.getFailureCount() + " Failures.");
        if (r.getFailureCount() > 0) {
            for (Failure f : r.getFailures()) {
                System.out.println(f.getMessage());
            }
        }
        r = JUnitCore.runClasses(ProjectListTest.class);
        System.out.println("ProjectList Tests: " + r.getRunCount() + " Tests completed in " + r.getRunTime() + "ms. "
                + r.getFailureCount() + " Failures.");
        if (r.getFailureCount() > 0) {
            for (Failure f : r.getFailures()) {
                System.out.println(f.getMessage());
            }
        }
        System.out.println("#################################\n");
        System.out.println("#################################");
        System.out.println("#        Tests finished         #");
        System.out.println("#################################");
        System.exit(0);
    }

}