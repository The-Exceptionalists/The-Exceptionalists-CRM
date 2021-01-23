package com.ironhack.crm.classes;

import com.ironhack.crm.classes.Lead;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeadTest {



    @Test
    void setName_noEmpty_true() {
        Lead lead = new Lead ("Juan Alberto", "juan@juan.es", "Juan's Company", "669695702");
        assertTrue(lead.getName().length() > 0);
    }
    @Test
    void setName_noMoreThan30Char_true() {
        Lead lead = new Lead ("Juan Alberto", "juan@juan.es", "Juan's Company", "669695702");
        assertTrue(lead.getName().length() < 31);
    }
    @Test
    void setName_work_name() {
        Lead lead = new Lead ("Juan Alberto", "juan@juan.es", "Juan's Company", "669695702");
        lead.setName("Juan");
        assertEquals("Juan", lead.getName());
        lead.setName("Juan Alberto");
        assertEquals("Juan Alberto", lead.getName());
        lead.setName("Antonio Jesús");
        assertEquals("Antonio Jesús", lead.getName());
    }

    @Test
    void setName_throwEmptyError_IllegalArgumentException() {
        Lead lead = new Lead ("Juan", "juan@juan.es", "Juan's Company", "669695702");
        assertThrows(IllegalArgumentException.class, ()->lead.setName(""));
    }
    @Test
    void setName_throw31CharError_IllegalArgumentException() {
        Lead lead = new Lead ("Antonio Jesús", "juan@juan.es", "Juan's Company", "669695702");
        assertThrows(IllegalArgumentException.class, ()->lead.setName("juanalrnoldoamistayamoranombre muylargomasetreintaestnoselocree"));
    }

    @Test
    void setEmail_noEmpty_true() {
    }
    @Test
    void setEmail_emailStructure_correctEmail() {
    }

    @Test
    void setCompanyName_noEmpty_true() {
    }
    @Test
    void setCompanyName_noMoreThan30_true() {
    }


    @Test
    void setPhoneNumber_noEmpty_correctPhone() {
    }
    @Test
    void setPhoneNumber_phoneStructure_correctPhone() {
    }
}