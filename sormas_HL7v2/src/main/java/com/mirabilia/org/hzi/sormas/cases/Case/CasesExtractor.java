/*
 * Copyright (c) 2021, Mathew Official
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.mirabilia.org.hzi.sormas.cases.Case;

import com.mirabilia.org.hzi.sormas.cases.*;
import com.mirabilia.org.hzi.Strings.sql;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathew Official
 */
public class CasesExtractor {

    public static void SormasCasePull(String lev) throws ClassNotFoundException {
        SimpleDateFormat frnmt = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Connection cox = DbConnector.getPgConnection();
            PreparedStatement pa = null;
            ResultSet ra = null;

            if ("2".equals(lev)) {
                //System.out.println("1111111111111111");
                pa = cox.prepareStatement(sql.getCases);
            }
            if ("3".equals(lev)) {
                //   pa = cox.prepareStatement(sql.getSROMAS_district_Aggregate_AllCases);
            }
            if ("4".equals(lev)) {
                //  pa = cox.prepareStatement(sql.getSROMAS_community_PG);
            }
            if ("5".equals(lev)) {
                //   pa = cox.prepareStatement(sql.getSROMAS_hf_PG);
            }

            ra = pa.executeQuery();
            while (ra.next()) {

                CasesUtilityClass.setAddress(ra.getString("address_id"));
                CasesUtilityClass.setAddtionaldetails(ra.getString("additionaldetails"));
                CasesUtilityClass.setApproximateage(ra.getString("Approximateage"));

                CasesUtilityClass.setApproximate_Age_Reference_Date(ra.getString("ApproximateAgeReferenceDate"));

                CasesUtilityClass.setApproximateagetype(ra.getString("Approximateagetype"));
                CasesUtilityClass.setArmedforcesrelationtype(ra.getString("Armedforcesrelationtype"));
                CasesUtilityClass.setBirthcountry_Id(ra.getString("Birthcountry_id"));

                if (null != ra.getString("Birthdate_dd")) {
                    String dx = ra.getString("Birthdate_dd");
                    CasesUtilityClass.setBirthdate(dx.substring(0, dx.indexOf(" ")));
                }

                if (null != ra.getString("Birthdate_mm")) {
                    String dx = ra.getString("Birthdate_mm");
                    CasesUtilityClass.setBirthdate_Month(dx.substring(0, dx.indexOf(" ")));
                }

                if (null != ra.getString("Birthdate_yyyy")) {
                    String dx = ra.getString("Birthdate_yyyy");
                    CasesUtilityClass.setBirthdate_Year(dx.substring(0, dx.indexOf(" ")));
                }
                CasesUtilityClass.setBirthname(ra.getString("Birthname"));
                CasesUtilityClass.setBirthweight(ra.getString("Birthweight"));
                CasesUtilityClass.setBurialconductor(ra.getString("Burialconductor"));

                CasesUtilityClass.setBurialdate(ra.getString("Burialdate"));
                CasesUtilityClass.setBurial_Place_Description(ra.getString("BurialPlaceDescription"));
                CasesUtilityClass.setCause_of_Death(ra.getString("CauseofDeath"));
                CasesUtilityClass.setCause_of_Death_Details(ra.getString("CauseofDeathDetails"));
                CasesUtilityClass.setCause_of_Death_Disease(ra.getString("CauseofDeathDisease"));
                if (null != ra.getString("Changedate")) {
                    String dx = ra.getString("Changedate");
                    CasesUtilityClass.setChangedate(dx.substring(0, dx.indexOf(" ")));
                }
                if (null != ra.getString("Changedateofembeddedlists")) {
                    String dx = ra.getString("Changedateofembeddedlists");
                    CasesUtilityClass.setChangedateofembeddedlists(dx.substring(0, dx.indexOf(" ")));
                }
                CasesUtilityClass.setCitizenship_Id(ra.getString("Citizenship_id"));
                CasesUtilityClass.setCovidcodedelivered(ra.getString("Covidcodedelivered"));
                if (null != ra.getString("Creationdate")) {
                    String dx = ra.getString("Creationdate");
                    CasesUtilityClass.setCreationdate(dx.substring(0, dx.indexOf(" ")));
                }

                CasesUtilityClass.setDeathdate(ra.getString("Deathdate"));
                CasesUtilityClass.setDeath_Place_Description(ra.getString("DeathPlaceDescription"));
                CasesUtilityClass.setDeath_Place_Type(ra.getString("DeathPlaceType"));
                CasesUtilityClass.setEducation_Details(ra.getString("EducationDetails"));
                CasesUtilityClass.setEducation_Type(ra.getString("EducationType"));
                CasesUtilityClass.setExternalid(ra.getString("Externalid"));
                CasesUtilityClass.setExternaltoken(ra.getString("Externaltoken"));
                CasesUtilityClass.setFathersname(ra.getString("Fathersname"));
                CasesUtilityClass.setFirstname(ra.getString("Firstname"));
                CasesUtilityClass.setGestationageatbirth(ra.getString("Gestationageatbirth"));
                CasesUtilityClass.setHascovidapp(ra.getString("Hascovidapp"));
                CasesUtilityClass.setMothersmaidenname(ra.getString("Mothersmaidenname"));
                CasesUtilityClass.setMothersname(ra.getString("Mothersname"));
                CasesUtilityClass.setNameofguardians(ra.getString("namesofguardians"));
                CasesUtilityClass.setNationalhealth_Id(ra.getString("Nationalhealthid"));
                CasesUtilityClass.setNickname(ra.getString("Nickname"));
                CasesUtilityClass.setOccupationdetails(ra.getString("Occupationdetails"));
                CasesUtilityClass.setOccupationtype(ra.getString("Occupationtype"));
                CasesUtilityClass.setOthersalutation(ra.getString("Othersalutation"));
                CasesUtilityClass.setPassportnumber(ra.getString("Passportnumber"));
                CasesUtilityClass.setPlaceofbirthcommunity_Id(ra.getString("Placeofbirthcommunity_id"));
                CasesUtilityClass.setPlaceofbirthdistrict_Id(ra.getString("Placeofbirthdistrict_id"));
                CasesUtilityClass.setPlaceofbirthfacilitydetails(ra.getString("Placeofbirthfacilitydetails"));
                CasesUtilityClass.setPlaceofbirthfacility_Id(ra.getString("Placeofbirthfacility_id"));
                CasesUtilityClass.setPlaceofbirthfacilitytype(ra.getString("Placeofbirthfacilitytype"));
                CasesUtilityClass.setPlaceofbirthregion_Id(ra.getString("Placeofbirthregion_id"));
                CasesUtilityClass.setPresentcondition(ra.getString("Presentcondition"));
                CasesUtilityClass.setSalutation(ra.getString("Salutation"));
                CasesUtilityClass.setSex(ra.getString("Sex"));
                CasesUtilityClass.setSormas_System_Period(ra.getString("sys_Period"));
                CasesUtilityClass.setSRM_Uuid(ra.getString("Uuid"));
                CasesUtilityClass.setSymptomjournalstatus(ra.getString("Symptomjournalstatus"));//r.externalid
                CasesUtilityClass.setExternal_id(ra.getString("externalid_region"));
                CasesUtilityClass.setC_id(ra.getString("id_case"));

                personSender.jsonDHISSender();

            }

        } catch (SQLException ex) {
            Logger.getLogger(CasesExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
