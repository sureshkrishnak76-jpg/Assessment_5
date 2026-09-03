package com.vit.voting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VotingSystemTest {

    @Test
    public void testEligibleVoter() {
        Voter eligibleVoter = new Voter("Amit Kumar", 22, "Indian", "VID12345", true);
        assertEquals("ELIGIBLE", VotingSystem.evaluateEligibility(eligibleVoter));
    }

    @Test
    public void testUnderageVoter() {
        Voter underageVoter = new Voter("Rahul", 16, "Indian", "VID54321", true);
        assertTrue(VotingSystem.evaluateEligibility(underageVoter).contains("Underage"));
    }

    @Test
    public void testNonCitizenVoter() {
        Voter foreigner = new Voter("John Doe", 30, "American", "VID99999", true);
        assertTrue(VotingSystem.evaluateEligibility(foreigner).contains("Not a citizen"));
    }
}
