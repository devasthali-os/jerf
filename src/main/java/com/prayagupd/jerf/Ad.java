package com.prayagupd.jerf;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class Ad {
    public String adId;
    public ZonedDateTime sentAt;
    public ZonedDateTime viewedAt;
    public String location;
}
