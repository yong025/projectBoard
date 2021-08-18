package org.zerock.projectboard.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private int bno,viewcount;
    private String title,content,writer;
    private Timestamp regdate;
}
