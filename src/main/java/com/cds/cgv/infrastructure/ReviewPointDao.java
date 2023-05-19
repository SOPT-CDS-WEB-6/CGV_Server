package com.cds.cgv.infrastructure;

import com.cds.cgv.controller.dto.response.CharmingPointRes;
import com.cds.cgv.controller.dto.response.EmotionPointRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ReviewPointDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
     public CharmingPointRes getCharmingPointStats(Long movieNumber){
         String getCharmingPointStatsQuery =
                 "select " +
                 "    ( count(directing) / if(count(*)=0, 1, count(*)) )*5+5 as directing_score, " +
                 "    ( count(story) / if(count(*)=0, 1, count(*)) )*5+5 as story_score, " +
                 "    ( count(visual_beauty) / if(count(*)=0, 1, count(*)) )*5+5 as visual_beauty_score, " +
                 "    ( count(acting) / if(count(*)=0, 1, count(*)) )*5+5 as acting_score, " +
                 "    ( count(ost_quality) / if(count(*)=0, 1, count(*)) )*5+5 as ost_quality_score " +
                 "from review_point_charming as rpc " +
                 "    join review as r " +
                 "        on (rpc.review_number = r.review_number) " +
                 "where r.movie_number = ?;";

         return this.jdbcTemplate.queryForObject(
                 getCharmingPointStatsQuery,
                 (rs, rowNum) -> new CharmingPointRes(
                         rs.getFloat("directing_score"),
                         rs.getFloat("story_score"),
                         rs.getFloat("visual_beauty_score"),
                         rs.getFloat("acting_score"),
                         rs.getFloat("ost_quality_score")
                 ),
                 movieNumber);
     }
    public EmotionPointRes getEmotionPointStats(Long movieNumber){
        String getEmotionPointStatsQuery =
                "select " +
                "    ( count(stress_relief) / if(count(*)=0, 1, count(*)) )*5+5 as stress_relief_score, " +
                "    ( count(pleasure) / if(count(*)=0, 1, count(*)) )*5+5 as pleasure_score, " +
                "    ( count(tension) / if(count(*)=0, 1, count(*)) )*5+5 as tension_score, " +
                "    ( count(immersion) / if(count(*)=0, 1, count(*)) )*5+5 as immersion_score, " +
                "    ( count(moving) / if(count(*)=0, 1, count(*)) )*5+5 as moving_score " +
                "from review_point_emotion as rpe " +
                "    join review as r " +
                "        on (rpe.review_number = r.review_number)\n" +
                "where r.movie_number = ?;";

        return this.jdbcTemplate.queryForObject(
                getEmotionPointStatsQuery,
                (rs, rowNum) -> new EmotionPointRes(
                        rs.getFloat("stress_relief_score"),
                        rs.getFloat("pleasure_score"),
                        rs.getFloat("tension_score"),
                        rs.getFloat("immersion_score"),
                        rs.getFloat("moving_score")
                ),
                movieNumber);
    }
}
