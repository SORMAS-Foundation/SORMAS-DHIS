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

    public static String getSROMAS_district_PG = "select count(*), c.disease, (select name from district where id = c.district_id), (select externalid from district where id = c.district_id), c.creationdate::date\n"
            + "from cases c\n"
            + "left join district r on (c.district_id = r.id)\n"
            + "group by c.disease, c.district_id, c.creationdate::date";

    public static String getSROMAS_region_PG = "select count(*), c.disease, (select name from region where id = c.region_id), (select externalid from region where id = c.region_id), c.creationdate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "group by c.disease, c.region_id, c.creationdate::date";

    public static String getSROMAS_community_PG = "select count(*), c.disease, (select name from community where id = c.community_id), (select externalid from community where id = c.community_id), c.creationdate::date\n"
            + "from cases c\n"
            + "left join community r on (c.community_id = r.id)\n"
            + "group by c.disease, c.community_id, c.creationdate::date";

    public static String getSROMAS_hf_PG = "select count(*), c.disease, (select name from facility where id = c.healthfacility_id), (select externalid from facility where id = c.healthfacility_id), c.creationdate::date\n"
            + "from cases c\n"
            + "left join facility r on (c.healthfacility_id = r.id)\n"
            + "group by c.disease, c.healthfacility_id, c.creationdate::date";

    public static String getSROMAS_district_PG_outc = "select count(*), c.outcome, (select name from district where id = c.district_id), (select externalid from district where id = c.district_id), c.outcomedate::date\n"
            + "from cases c\n"
            + "left join district r on (c.district_id = r.id)\n"
            + "group by c.outcome, c.district_id, c.outcomedate::date";

    public static String getSROMAS_region_PG_outc = "select count(*), c.outcome, (select name from region where id = c.region_id), (select externalid from region where id = c.region_id), c.outcomedate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "group by c.outcome, c.region_id, c.outcomedate::date";

    public static String getSROMAS_community_PG_outc = "select count(*), c.outcome, (select name from community where id = c.community_id), (select externalid from community where id = c.community_id), c.outcomedate::date\n"
            + "from cases c\n"
            + "left join community r on (c.community_id = r.id)\n"
            + "group by c.outcome, c.community_id, c.outcomedate::date";

    public static String getSROMAS_hf_PG_outc = "select count(*), c.outcome, (select name from facility where id = c.healthfacility_id), (select externalid from facility where id = c.healthfacility_id), c.outcomedate::date\n"
            + "from cases c\n"
            + "left join facility r on (c.healthfacility_id = r.id)\n"
            + "group by c.outcome, c.healthfacility_id, c.outcomedate::date";

    public static String getSROMAS_district_PG_class = "select count(*), c.caseclassification, (select name from district where id = c.district_id), (select externalid from district where id = c.district_id), c.classificationdate::date\n"
            + "from cases c\n"
            + "left join district r on (c.district_id = r.id)\n"
            + "group by c.caseclassification, c.district_id, c.classificationdate::date";

    public static String getSROMAS_region_PG_class = "select count(*), c.caseclassification, (select name from region where id = c.region_id), (select externalid from region where id = c.region_id), c.classificationdate::date\n"
            + "from cases c\n"
            + "left join region r on (c.region_id = r.id)\n"
            + "group by c.caseclassification, c.region_id, c.classificationdate::date";

    public static String getSROMAS_community_PG_class = "select count(*), c.caseclassification, (select name from community where id = c.community_id), (select externalid from community where id = c.community_id), c.classificationdate::date\n"
            + "from cases c\n"
            + "left join community r on (c.community_id = r.id)\n"
            + "group by c.caseclassification, c.community_id, c.classificationdate::date";

    public static String getSROMAS_hf_PG_class = "select count(*), c.caseclassification, (select name from facility where id = c.healthfacility_id), (select externalid from facility where id = c.healthfacility_id), c.classificationdate::date\n"
            + "from cases c\n"
            + "left join facility r on (c.healthfacility_id = r.id)\n"
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

    // public static String Get_all_Isolated_today = "";
    // public static String Get_all_Isolated_today = "";
    // public static String Get_all_Isolated_today = "";
    // public static String Get_all_Isolated_today = "";
}
