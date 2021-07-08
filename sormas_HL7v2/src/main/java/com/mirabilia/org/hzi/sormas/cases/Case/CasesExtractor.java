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
import com.mirabilia.org.hzi.sormas.aggregate.SendToDHISServer;
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
                
                CasesUtilityClass.setC_id(ra.getString("Id"));
                CasesUtilityClass.setCaseage(ra.getString("caseage"));
                CasesUtilityClass.setCaseclassification(ra.getString("caseclassification"));
                CasesUtilityClass.setCaseorigin(ra.getString("caseorigin"));
                CasesUtilityClass.setDisease(ra.getString("disease"));
                CasesUtilityClass.setOutcome(ra.getString("outcome"));
                
                //impliment coordinates
                
                
                //implement UUID
                
                String rett = SendToDHISServer.get_trackEntity("select external_id from person where id = ?", ra.getString("Id"));
                CasesUtilityClass.setTrackedentity_id(rett);
                
                CaseSender.jsonDHISSender();

            }

        } catch (SQLException ex) {
            Logger.getLogger(CasesExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
