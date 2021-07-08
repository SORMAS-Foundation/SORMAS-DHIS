/*
 * Copyright (c) 2020, Mathew Official
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
package com.mirabilia.org.hzi.Strings;

/**
 *
 * @author Mathew Official
 */
public class sql {

    public static String dash_table_counter = "select d.created, s.namex, s.adapter_cdate, s.resolved_by from sormas_local s, raw_ d where s.externalid = d.uuid order by s.adapter_cdate asc limit 5";

    public static String dup_count_all_from_sorma_local = "SELECT count(*) FROM sormas_local d WHERE d.`level` = 2 and d.duplicate_with is not null and d.duplicate_with != '';";

    public static String sync_count_all_synced = "SELECT count(*) FROM sormas_local d WHERE synced = 1;";

    public static String sync_primer_all_matched = "SELECT uuid, level, externalid, idx FROM sormas_local d WHERE (d.duplicate_with is null or d.duplicate_with = '') and (d.externalid != '' or d.externalid is not null);";

    public static String sync_primer_all_fresh = "select path_parent from raw_ where level = ? order by idx asc";

    public static String sync_primer_all_fresh_ = "select idx from raw_ where uuid = ? order by idx asc";
    public static String sync_all_fresh = "select name, uuid, idx, rec_created, level  from raw_ where level = ? and path_parent like '%?%'";

    public static String sync_primer_all_new_matched = "SELECT name, level, externalid, idx, rec_created FROM sormas_local d WHERE (d.duplicate_with is null or d.duplicate_with = '') and (d.externalid != '' or d.externalid is not null);";

    public static String getSROMAS_district_Aggregate_AllCases = "select count(*), c.disease, (select externalid from district where id = c.district_id), c.creationdate::date\n"
            + "from cases c\n"
            + "left join district r on (c.district_id = r.id)\n"
            + "where c.id = ?"
            + "group by c.disease, c.district_id, c.creationdate::date";
//no of cases by disease
    public static String getSROMAS_region_Aggregate_AllCases = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date, c.region_id, r.name\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "group by c.disease, c.region_id, c.reportdate::date, r.name";

//no of cases in country
    public static String getSORMAS_INCOUNTRY = "select count(*), c.disease\n"
            + "from cases c\n"
            + "where c.pointofentry_id is null and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease";

//no of cases in country
    public static String getSORMAS_IMPORTED = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "where c.pointofentry_id is not null and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date";

    //no of cases OUTCOME = DEATH
    public static String getSORMAS_DEATH = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "where c.outcome = 'DECEASED' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date";

    //no of cases OUTCOME = RECOVERED
    public static String getSORMAS_RECOVERED = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "where c.outcome = 'RECOVERED' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date";

    //no of cases OUTCOME != RECOVERED && NOT DIED
    public static String getSORMAS_NOT_RECOVERED_AND_NOT_DEATH = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "where c.outcome != 'RECOVERED' AND c.outcome = 'DECEASED' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date";
    //Age <=5
    public static String Age_LESS_5 = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date\n"
            + "from cases c\n"
            + "where c.caseage <= 5 and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date, c.quarantine";

    //Age >=5 <= 14yr
    public static String Age_LESS5_GREATER_14 = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date\n"
            + "from cases c\n"
            + "where c.caseage between 5 and 14 and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date, c.quarantine";

    //>14 <= 40yr
    public static String Age_greater_14_and_less_40 = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date, c.caseage\n"
            + "from cases c\n"
            + "where c.caseage between 14 and 40 and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date, c.quarantine, c.caseage";

    //>40 <=65yr
    public static String Age__grat40_less65 = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date, c.caseage\n"
            + "from cases c\n"
            + "where c.caseage > 40 and  c.caseage <= 65 and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date, c.quarantine, c.caseage";

    //>65 <=80yr
    public static String Age_grater65_less80yr = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date, c.caseage\n"
            + "from cases c\n"
            + "where c.caseage > 65 and  c.caseage <= 80 and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date, c.quarantine, c.caseage";

    //>80yr
    public static String Age_above_80 = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date,c.caseage\n"
            + "from cases c\n"
            + "where c.caseage > 80 and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date, c.quarantine, c.caseage";

    //Missing/Unknown
    public static String Age_Missing_Unknown = "select count(*), c.disease, (select externalid from region where id = c.region_id), c.reportdate::date,c.caseage\n"
            + "from cases c\n"
            + "where c.caseage is null and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.region_id, c.reportdate::date, c.quarantine, c.caseage";

    //occupation health worker
    public static String Occupation_Health_Worker = "select count(*), c.disease, c.reportdate::date, p.occupationtype\n"
            + "from cases c\n"
            + "left join person p on (c.person_id = p.id)\n"
            + "where p.occupationtype = 'healthworker' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, p.occupationtype";

    //occupation lab staff
    public static String Occupation_Lab_Staff = "select count(*), c.disease, c.reportdate::date, p.occupationtype\n"
            + "from cases c\n"
            + "left join person p on (c.person_id = p.id)\n"
            + "where p.occupationtype is = 'laboratory staff' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, p.occupationtype";

    //occupation others 
    public static String Occupation_others = "select count(*), c.disease, c.reportdate::date, p.occupationtype\n"
            + "from cases c\n"
            + "left join person p on (c.person_id = p.id)\n"
            + "where p.occupationtype != 'laboratory staff'  and p.occupationtype != 'healthworker'  and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, p.occupationtype";

    //occupation missing unknown
    public static String Occupation_unknow_missing = "select count(*), c.disease, c.reportdate::date, p.occupationtype\n"
            + "from cases c\n"
            + "left join person p on (c.person_id = p.id)\n"
            + "where (p.occupationtype is null and c.region_id = ? and c.reportdate::date = ?)\n"
            + "group by c.disease, c.person_id, c.reportdate::date, p.occupationtype";

    //Gender Male
    public static String Male = "select count(*), c.disease, c.reportdate::date, p.sex\n"
            + "from cases c\n"
            + "left join person p on (c.person_id = p.id)\n"
            + "where p.sex='MALE' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, p.sex";

    //Gender Female
    public static String female = "select count(*), c.disease, c.reportdate::date, p.sex\n"
            + "from cases c\n"
            + "left join person p on (c.person_id = p.id)\n"
            + "where p.sex='FEMALE' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, p.sex";

    //Gender Others
    public static String gender_others = "select count(*), c.disease, c.reportdate::date, p.sex\n"
            + "from cases c\n"
            + "left join person p on (c.person_id = p.id)\n"
            + "where p.sex != 'FEMALE' and p.sex != 'MALE' and p.sex is not null and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, p.sex";

    //Gender Unknown
    public static String gender_missing = "select count(*), c.disease, c.reportdate::date, p.sex\n"
            + "from cases c\n"
            + "left join person p on (c.person_id = p.id)\n"
            + "where  p.sex is null and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, p.sex";

    //Confirmed not by laboratory  
    public static String confirmed_lab = "select count(*), c.disease, c.reportdate::date, c.laboratorydiagnosticconfirmation\n"
            + "from cases c\n"
            + "where c.laboratorydiagnosticconfirmation='YES' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, c.laboratorydiagnosticconfirmation";

    public static String not_confirmed_lab = "select count(*), c.disease, c.reportdate::date, c.laboratorydiagnosticconfirmation\n"
            + "from cases c\n"
            + "where c.laboratorydiagnosticconfirmation !='NO' and c.region_id = ? and c.reportdate::date = ?\n"
            + "group by c.disease, c.person_id, c.reportdate::date, c.laboratorydiagnosticconfirmation";

    public static String getSROMAS_community_PG = "select count(*), c.disease, (select name from community where id = c.community_id), (select externalid from community where id = c.community_id), c.creationdate::date\n"
            + "from cases c\n"
            + "left join community r on (c.community_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.disease, c.community_id, c.creationdate::date";

    public static String getSROMAS_hf_PG = "select count(*), c.disease, (select name from facility where id = c.healthfacility_id), (select externalid from facility where id = c.healthfacility_id), c.creationdate::date\n"
            + "from cases c\n"
            + "left join facility r on (c.healthfacility_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.disease, c.healthfacility_id, c.creationdate::date";

    public static String getSROMAS_district_PG_outc = "select count(*), c.outcome, (select name from district where id = c.district_id), (select externalid from district where id = c.district_id), c.outcomedate::date\n"
            + "from cases c\n"
            + "left join district r on (c.district_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.outcome, c.district_id, c.outcomedate::date";

    public static String getSROMAS_region_PG_outc = "select count(*), c.outcome, (select name from region where id = c.region_id), (select externalid from region where id = c.region_id), c.outcomedate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.outcome, c.region_id, c.outcomedate::date";

    public static String getSROMAS_community_PG_outc = "select count(*), c.outcome, (select name from community where id = c.community_id), (select externalid from community where id = c.community_id), c.outcomedate::date\n"
            + "from cases c\n"
            + "left join community r on (c.community_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.outcome, c.community_id, c.outcomedate::date";

    public static String getSROMAS_hf_PG_outc = "select count(*), c.outcome, (select name from facility where id = c.healthfacility_id), (select externalid from facility where id = c.healthfacility_id), c.outcomedate::date\n"
            + "from cases c\n"
            + "left join facility r on (c.healthfacility_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.outcome, c.healthfacility_id, c.outcomedate::date";

    public static String getSROMAS_district_PG_class = "select count(*), c.caseclassification, (select name from district where id = c.district_id), (select externalid from district where id = c.district_id), c.classificationdate::date\n"
            + "from cases c\n"
            + "left join district r on (c.district_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.caseclassification, c.district_id, c.classificationdate::date";

    public static String getSROMAS_region_PG_class = "select count(*), c.caseclassification, (select name from region where id = c.region_id), (select externalid from region where id = c.region_id), c.classificationdate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.caseclassification, c.region_id, c.classificationdate::date";

    public static String getSROMAS_community_PG_class = "select count(*), c.caseclassification, (select name from community where id = c.community_id), (select externalid from community where id = c.community_id), c.classificationdate::date\n"
            + "from cases c\n"
            + "left join community r on (c.community_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.caseclassification, c.community_id, c.classificationdate::date";

    public static String getSROMAS_hf_PG_class = "select count(*), c.caseclassification, (select name from facility where id = c.healthfacility_id), (select externalid from facility where id = c.healthfacility_id), c.classificationdate::date\n"
            + "from cases c\n"
            + "left join facility r on (c.healthfacility_id = r.id)\n"
            + "where c.region_id = ?\n"
            + "group by c.caseclassification, c.healthfacility_id, c.classificationdate::date";

    public static String sync_send_all_matched_My = "update raw_ set synced = 1 where idx = ?;";

    //public static String dup_count_matched_no = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 2";
    // public static String dup_count_all_from_source_no= "SELECT count(*) FROM raw_ r WHERE r.`level` = 2;";
    public static String dup_count_matched_name = "select namex, uuid from sormas_local where level = 2;";
    public static String dup_L2_count_by_level_using_parent_source_name_details = "select * from sormas_local s where  s.duplicate_with is not null and s.duplicate_with != '' and level = 2 and namex like ?";
    public static String dup_L3_count_by_level_using_parent_source_name_details = "select * from sormas_local s where  s.duplicate_with is not null and s.duplicate_with != '' and level = 3 and parent_id = (select uid from sormas_local where level = 2 and uuid like ?)";
    public static String L4_dup_L3_count_by_level_using_parent_source_name_details = "select * from sormas_local s where  s.duplicate_with is not null and s.duplicate_with != '' and level = 4 and parent_id = (select uid from sormas_local where level = 3 and namex like ?)";
    public static String dup__SUB_count_by_level_using_parent_source_name_details = "select * from raw_ r where r.uuid in ";

    public static String dup_count_by_level_using_parent_source_name = " SELECT count(*) FROM sormas_local WHERE level = 3 and parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 2) and duplicate_with is not null and duplicate_with != ''";
    public static String L4_dup_count_by_level_using_parent_source_name = " SELECT count(*) FROM sormas_local WHERE level = 4 and parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 3) and duplicate_with is not null and duplicate_with != ''";
    public static String L5_dup_count_by_level_using_parent_source_name = " SELECT count(*) FROM sormas_local WHERE level = 5 and parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 4) and duplicate_with is not null and duplicate_with != ''";

//SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 3 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 2) and (d.duplicate_with is null or d.duplicate_with = '');
    public static String cdup_ount_by_level_using_parent_source_name_xx = "SELECT d.namex, d.uuid from sormas_local d WHERE d.`level` = 3 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 2)";
    public static String L4_cdup_ount_by_level_using_parent_source_name_xx = "SELECT d.namex, d.uuid from sormas_local d WHERE d.`level` = 4 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 3)";

    public static String L5_cdup_ount_by_level_using_parent_source_name_xx = "SELECT d.namex, d.uuid from sormas_local d WHERE d.`level` = 5 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 4)";

    public static String count_all_from_source = "SELECT * FROM raw_ r WHERE r.`level` = 2;";
    public static String count_all_from_destination = "SELECT * FROM sormas_local d WHERE d.`level` = 2";
    public static String count_matched = "SELECT * FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 2";

    public static String count_all_from_source_no = "SELECT count(*) FROM raw_ r WHERE r.`level` = 2;";
    public static String count_all_from_destination_no = "SELECT count(*) FROM sormas_local d WHERE d.`level` = 2";
    public static String count_matched_no = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 2";
    public static String count_matched_name = "SELECT d.namex, d.uuid FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 2";

    public static String count_all_byparent_from_source_no = "SELECT count(*) FROM raw_ r WHERE r.`level` = ? and r.parent_id = ?";
    public static String count_all_byparent_from_destination_no = "SELECT count(*) FROM sormas_local d WHERE d.`level` = ? and r.parent_id = ?";
    public static String count__byparent_matched_no = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = ? and r.parent_id = ?";
    public static String count__parent_matched_name = "SELECT d.namex FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = ? and r.parent_id = ?";

    public static String count_by_level_using_parent = "select count(*) from sormas_local s where s.parent_id = (select s.uid from sormas_local s where s.uuid like ?  and level = 2) and level = 3";
    public static String count_by_level_using_parent_source_q1 = "select s.externalid from sormas_local s where s.uuid like ?  and level = 2;";
    public static String count_by_level_using_parent_source_q2 = "select count(*) from raw_ s where s.path_parent like ? and level = 3";
    public static String count_by_level_using_parent_source_name = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 3 and d.parent_id = (select sx.uid from sormas_local sx where sx.namex like (select s.namex from sormas_local s where s.uuid like ?  and level = 2)  and level = 2)  and (d.duplicate_with is null or d.duplicate_with = '')";
    public static String count_by_level_using_parent_source_name_xx = "SELECT d.namex, d.uuid from sormas_local d WHERE d.`level` = 3 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 2)";

    public static String L4_count_by_level_using_parent = "select count(*) from sormas_local s where s.parent_id = (select s.uid from sormas_local s where s.uuid like ?  and level = 3) and level = 4";
    public static String L4_count_by_level_using_parent_source_q1 = "select s.externalid from sormas_local s where s.uuid like ?  and level = 3";
    public static String L4_count_by_level_using_parent_source_q2 = "select count(*) from raw_ s where s.path_parent like ? and level = 4";
    public static String L4_count_by_level_using_parent_source_name = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` =4 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 3)";
    public static String L4_count_by_level_using_parent_source_name_xx = "SELECT d.namex, d.uuid FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 4 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 3)";

    //HF
    public static String L5_count_by_level_using_parent = "select count(*) from sormas_local s where s.parent_id = (select s.uid from sormas_local s where s.uuid like ?  and level = 4) and level = 5";
    public static String L5_count_by_level_using_parent_source_q1 = "select s.externalid from sormas_local s where s.uuid like ?  and level = 4";
    public static String L5_count_by_level_using_parent_source_q2 = "select count(*) from raw_ s where s.path_parent like ? and level = 5";
    public static String L5_count_by_level_using_parent_source_name = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` =5 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 4)";
    public static String L5_count_by_level_using_parent_source_name_xx = "SELECT d.namex, d.uuid FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 5 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 4)";

    public static String L4_count_by_level_using_parent_source_name_details = "SELECT d.uid, d.uuid, r.uuid, d.namex,  r.name, d.adapter_cdate FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 4 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 3)";
    public static String L3_count_by_level_using_parent_source_name_details = "SELECT d.uid, d.uuid, r.uuid, d.namex,  r.name, d.adapter_cdate FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 3 and d.parent_id = (select sx.uid from sormas_local sx where sx.uuid like ?  and level = 2)";
    public static String L2_count_by_level_using_parent_source_name_details = "SELECT   d.uid, d.uuid, r.uuid, d.namex,  r.name, d.adapter_cdate FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 2 and r.name like ?";

    public static String count_unmatched_at_destination = "SELECT * FROM sormas_local d WHERE d.uid not IN (SELECT dd.uid FROM raw_ r inner JOIN sormas_local dd ON (r.UUID = dd.externalid) WHERE r.`level` = 2) AND d.`level` = 2";
    public static String count_unmatched_at_destination_no = "SELECT COUNT(*) FROM sormas_local d WHERE d.uid not IN (SELECT dd.uid FROM raw_ r inner JOIN sormas_local dd ON (r.UUID = dd.externalid) WHERE r.`level` = 2) AND d.`level` = 2";
    public static String count_unmatched_at_source = "SELECT * FROM raw_ rr WHERE rr.uuid not IN (SELECT r.uuid FROM raw_ r inner JOIN sormas_local dd ON (r.UUID = dd.externalid) WHERE r.`level` = 2) AND rr.`level` = 2";
    public static String count_unmatched_at_source_no = "SELECT COUNT(*) FROM raw_ rr WHERE rr.uuid not IN (SELECT r.uuid FROM raw_ r inner JOIN sormas_local dd ON (r.UUID = dd.externalid) WHERE r.`level` = 2) AND rr.`level` = 2";

//Agregate Strings
    public static String Get_all_Tested_today = "select count(*), p.lab_id, (select externalid from region where id = f.region_id), f.region_id from pathogentest p left join facility f on (p.lab_id = f.id) where p.creationdate::date  = '2020-06-15' group by p.lab_id,f.region_id;";
    public static String Get_all_Hospitalized_today = "select count(*), region_id, (select externalid from region where id = region_id) from cases c left join hospitalization h on (c.hospitalization_id = h.id) where (admittedtohealthfacility = 'YES' OR isolated = 'YES') and (h.admissiondate::date  = '2020-06-15' or h.isolationdate::date  = '2020-06-15') group by region_id";
    public static String Get_all_Isolated_today = "select count(*), region_id, (select externalid from region where id = region_id) from cases c left join hospitalization h on (c.hospitalization_id = h.id) where isolated = 'YES' and h.isolationdate::date  = '2020-06-15' group by region_id";
    public static String Get_all_ICU_today = "";//no date on the table... cant track
    public static String Get_all_Suspect_CASES_PORTOFENTRY_today = "select count(*), region_id, (select externalid from region where id = region_id)  from samples s left join cases c on (s.associatedcase_id = c.id)\n"
            + "where (s.pathogentestresult is null or s.pathogentestresult = 'PENDING') and s.changedate::date = '2020-06-15' and c.id in (select id from cases where pointofentry_id is not null and creationdate::date = '2020-06-15') group by region_id";
    public static String Get_all_Suspected_Community_Transmitted_CASES_today = "select count(*), region_id, (select externalid from region where id = region_id)  from samples s left join cases c on (s.associatedcase_id = c.id)\n"
            + "where (s.pathogentestresult is null or s.pathogentestresult = 'PENDING') and s.changedate::date = '2020-06-15' and c.id not in (select id from cases where pointofentry_id is not null and creationdate::date = '2020-06-15') group by region_id";
    public static String Get_all_Confirmed_CASES_PORTOFENTRY_today = "select count(*), region_id, (select externalid from region where id = region_id) from samples s left join cases c on (s.associatedcase_id = c.id)\n"
            + "where  s.pathogentestresult = 'POSITIVE' and s.changedate::date = '2020-06-15' and c.id in (select id from cases where pointofentry_id is not null and creationdate::date = '2020-06-15') group by region_id";
    public static String Get_all_Confirmed_Community_Transmitted_CASES_today = "select count(*), region_id, (select externalid from region where id = region_id) from samples s left join cases c on (s.associatedcase_id = c.id)\n"
            + "where  s.pathogentestresult = 'POSITIVE' and s.changedate::date = '2020-06-15' and c.id not in (select id from cases where pointofentry_id is not null and creationdate::date = '2020-06-15') group by region_id";

    //CASE_BASE_NEW
    public static String getPersons_Record_to_TrackEntity = "select p.id, p.approximateage, p.burialconductor, p.burialdate, p.changedate, p.creationdate,\n"
            + "	p.deathdate, p.firstname, p.lastname, p.occupationdetails, p.occupationtype, p.presentcondition, \n"
            + "	p.sex, p.uuid, p.address_id, p.birthdate_dd, p.birthdate_mm, p.birthdate_yyyy, p.nickname, p.mothersmaidenname,\n"
            + "	p.deathplacetype, p.deathplacedescription, p.sys_period, p.causeofdeath, p.causeofdeathdetails, p.causeofdeathdisease, p.educationtype,\n"
            + "	p.educationdetails, p.approximateagereferencedate, p.approximateagetype, p.mothersname, p.fathersname, p.placeofbirthregion_id,\n"
            + "	p.placeofbirthdistrict_id, p.placeofbirthcommunity_id, p.placeofbirthfacility_id, p.placeofbirthfacilitydetails, p.gestationageatbirth,\n"
            + "	p.birthweight, p.passportnumber, p.nationalhealthid, p.placeofbirthfacilitytype, p.changedateofembeddedlists, \n"
            + "	p.symptomjournalstatus, p.hascovidapp, p.covidcodedelivered, p.externalid, p.armedforcesrelationtype,\n"
            + "	p.namesofguardians, p.additionaldetails, p.BurialPlaceDescription, p.salutation,"
            + "      p.othersalutation, p.birthname, p.birthcountry_id, p.citizenship_id, p.externaltoken, r.externalid as externalid_region, c.id as id_case\n"
            + "	from person p\n"
            + "	right join cases c on p.id = c.person_id\n"
            + "	right join region r on c.region_id = r.id\n"
            + "      where externalid is null";

    public static String getCases = "select c.id, c.perosn_id, c.creationdate, c.disease, c.caseclassification,\n"
            + "c.outcome, c.caseage, c.caseorigin\n"
            + "from cases c, person p\n"
            + "where c.changedate = ?\n"
            + "      where externalid is null";

    public static String getSamples = "select s.samplematerial, s.lab_id, s.pathogentestingrequested, s.pathogentestresult, s.fieldsampleid, s.samplingreason, s.labdetails, s.associatedcase_id\n"
            + "from samples s\n"
            + "where s.changedate = ?\n"
            + "      where externalid is null";


    // public static String Get_all_Isolated_today = "";
    // public static String Get_all_Isolated_today = "";
    // public static String Get_all_Isolated_today = "";
    // public static String Get_all_Isolated_today = "";
}
