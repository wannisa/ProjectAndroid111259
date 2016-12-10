package com.example.mrbennerham.calendar;

import android.app.Activity;
import android.util.Log;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by MR.BENNERHAM on 10/30/2016.
 */
public class AsyncInsertCalendar extends CalendarAsyncTask {


    //    private final Calendar entry;
    _Model name;

    AsyncInsertCalendar(MainActivity calendarSample, _Model name) {
        super(calendarSample);
//        this.entry = entry;
        this.name = name;
    }


    @Override
    protected void doInBackground() throws IOException {

        StartDate();
        EndDate();
        StartDate1();
//        event_half_w12_2();
//        event_half_w12_3();
//        event_half_w12_4();
//        event_half_w12_4();
//        event_half_w12_5();

    }

    String startdate = "เริ่มต้นประจำเดือน";

    public void StartDate() throws IOException {
        Event Start_Date = new Event()
                .setSummary(startdate)
                .setDescription("วันเริ่มต้นประจำเดือน");

        String date = name.getdate();
//        String timer = name.gettimer();
        String t = "T";
//        String a = date+t+timer;
        String startdate = date + t;
        DateTime startDateTime = new DateTime(startdate + "17:00:00+07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Asia/Bangkok");
        Start_Date.setStart(start);

        DateTime endDateTime = new DateTime(startdate + "17:00:00+07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Asia/Bangkok");
        Start_Date.setEnd(end);
//        String[] recurrence = new String[] {"RRULE:FREQ=DAILY;COUNT=2"}; //วนวันเดิม2ครั้ง
//        Start_Date.setRecurrence(Arrays.asList(recurrence));

//        EventAttendee[] attendees = new EventAttendee[] { //เชิญEmailอื่น
//                new EventAttendee().setEmail("pawarisaclinic58@gmail.com"),
////                new EventAttendee().setEmail("sbrin@example.com"),
//        };
//        Start_Date.setAttendees(Arrays.asList(attendees));

//        EventReminder[] reminderOverrides = new EventReminder[] {
//                new EventReminder().setMethod("email").setMinutes(24 * 60),
//                new EventReminder().setMethod("popup").setMinutes(10),
//        };
//        Event.Reminders reminders = new Event.Reminders()
//                .setUseDefault(false)
//                .setOverrides(Arrays.asList(reminderOverrides));
//        Start_Date.setReminders(reminders);

        Event createdEvent = client.events().insert("primary", Start_Date).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String enddate = "สิ้นสุดประจำเดือน";

    public void EndDate() throws IOException {

        Event End_Date = new Event()
                .setSummary(enddate)
                .setDescription("วันสิ้นสุดประจำเดือน");

        String date = name.getdateend();
//        String timer = name.gettimer();
        String t = "T";

//        String a = date+t+timer;
        String enddate = date + t;
        DateTime startDateTime = new DateTime(enddate + "17:00:00+07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Asia/Bangkok");
        End_Date.setStart(start);
        DateTime endDateTime = new DateTime(enddate + "17:00:00+07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Asia/Bangkok");
        End_Date.setEnd(end);

        Event createdEvent = client.events().insert("primary", End_Date).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    String startdate1 = "วันไข่ตก";

    public void StartDate1() throws IOException {
        Event Start_Date = new Event()
                .setSummary(startdate1)
                .setDescription("วันเริ่มต้นประจำเดือน");

        String date = name.getdate();

        /*********************************************/


        String dt = date;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar c = java.util.Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(java.util.Calendar.DATE, 12);  // number of days to add
        date = sdf.format(c.getTime());  // dt is now the new date

        /*********************************************/

//        String timer = name.gettimer();
        String t = "T";
//        String a = date+t+timer;
        String startdate1 = date + t;
        DateTime startDateTime = new DateTime(startdate1 + "17:00:00+07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Asia/Bangkok");
        Start_Date.setStart(start);

        DateTime endDateTime = new DateTime(startdate1 + "17:00:00+07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Asia/Bangkok");
        Start_Date.setEnd(end);
//        String[] recurrence = new String[] {"RRULE:FREQ=DAILY;COUNT=2"}; //วนวันเดิม2ครั้ง
//        Start_Date.setRecurrence(Arrays.asList(recurrence));

//        EventAttendee[] attendees = new EventAttendee[] { //เชิญEmailอื่น
//                new EventAttendee().setEmail("pawarisaclinic58@gmail.com"),
////                new EventAttendee().setEmail("sbrin@example.com"),
//        };
//        Start_Date.setAttendees(Arrays.asList(attendees));

//        EventReminder[] reminderOverrides = new EventReminder[] {
//                new EventReminder().setMethod("email").setMinutes(24 * 60),
//                new EventReminder().setMethod("popup").setMinutes(10),
//        };
//        Event.Reminders reminders = new Event.Reminders()
//                .setUseDefault(false)
//                .setOverrides(Arrays.asList(reminderOverrides));
//        Start_Date.setReminders(reminders);

        Event createdEvent = client.events().insert("primary", Start_Date).execute();
        System.out.println("Created event id: " + createdEvent.getId());
    }

    public void event_half_w12_2() throws IOException {
        Event eventH_w12_day2 = new Event()
                .setSummary("ทดสอบ 2");

        String t = "T";
        String date = name.getdate();
        String timer = name.gettimer();
        String zero = "0";
        String yearandmonth = date.substring(0, 7);
        String day = date.substring(8);
        Integer intvalueday = Integer.parseInt(day);
        intvalueday = intvalueday + 1;
        //  String hour = timer.substring(0)
        if (intvalueday < 10) {
            String a = yearandmonth + "-" + zero + intvalueday + t + timer;

            DateTime startDateTime = new DateTime(a + ":00+07:00");
            EventDateTime start = new EventDateTime()
                    .setDateTime(startDateTime)
                    .setTimeZone("Asia/Bangkok");
            eventH_w12_day2.setStart(start);
            DateTime endDateTime = new DateTime(a + ":00+07:00");
            EventDateTime end = new EventDateTime()
                    .setDateTime(endDateTime)
                    .setTimeZone("Asia/Bangkok");
            eventH_w12_day2.setEnd(end);
            Event createdEvent = client.events().insert("primary", eventH_w12_day2).execute();
            System.out.println("Created event id: " + createdEvent.getId());
        } else {
            String a = yearandmonth + "-" + intvalueday + t + timer;
        }
    }

    public void event_half_w12_3() throws IOException {
        Event eventH_w12_day3 = new Event()
                .setSummary("ทดสอบ 3");
        String t = "T";
        String date = name.getdate();
        String timer = name.gettimer();
        String zero = "0";
        String yearandmonth = date.substring(0, 7);
        String day = date.substring(8);
        Integer intvalueday = Integer.parseInt(day);
        intvalueday = intvalueday + 2;
        //  String hour = timer.substring(0)
        if (intvalueday < 10) {
            String a = yearandmonth + "-" + zero + intvalueday + t + timer;

            DateTime startDateTime = new DateTime(a + ":00+07:00");
            EventDateTime start = new EventDateTime()
                    .setDateTime(startDateTime)
                    .setTimeZone("Asia/Bangkok");
            eventH_w12_day3.setStart(start);
            DateTime endDateTime = new DateTime(a + ":00+07:00");
            EventDateTime end = new EventDateTime()
                    .setDateTime(endDateTime)
                    .setTimeZone("Asia/Bangkok");
            eventH_w12_day3.setEnd(end);
            Event createdEvent = client.events().insert("primary", eventH_w12_day3).execute();
            System.out.println("Created event id: " + createdEvent.getId());
        } else {
            String a = yearandmonth + "-" + intvalueday + t + timer;
        }
    }

    public void event_half_w12_4() throws IOException {
        Event eventH_w12_day4 = new Event()
                .setSummary("ทดสอบ 4");
        String t = "T";
        String date = name.getdate();
        String timer = name.gettimer();
        String zero = "0";
        String yearandmonth = date.substring(0, 7);
        String day = date.substring(8);
        Integer intvalueday = Integer.parseInt(day);
        intvalueday = intvalueday + 3;
        //  String hour = timer.substring(0)
        if (intvalueday < 10) {
            String a = yearandmonth + "-" + zero + intvalueday + t + timer;

            DateTime startDateTime = new DateTime(a + ":00+07:00");
            EventDateTime start = new EventDateTime()
                    .setDateTime(startDateTime)
                    .setTimeZone("Asia/Bangkok");
            eventH_w12_day4.setStart(start);
            DateTime endDateTime = new DateTime(a + ":00+07:00");
            EventDateTime end = new EventDateTime()
                    .setDateTime(endDateTime)
                    .setTimeZone("Asia/Bangkok");
            eventH_w12_day4.setEnd(end);
            Event createdEvent = client.events().insert("primary", eventH_w12_day4).execute();
            System.out.println("Created event id: " + createdEvent.getId());
        } else {
            String a = yearandmonth + "-" + intvalueday + t + timer;
        }
    }

    public void event_half_w12_5() throws IOException {
        Event eventH_w12_day5 = new Event()
                .setSummary("ทดสอบ 5");
        String t = "T";
        String date = name.getdate();
        String timer = name.gettimer();
        String zero = "0";
        String yearandmonth = date.substring(0, 7);
        String day = date.substring(8);
        Integer intvalueday = Integer.parseInt(day);
        intvalueday = intvalueday + 4;
        //  String hour = timer.substring(0)
        if (intvalueday < 10) {
            String a = yearandmonth + "-" + zero + intvalueday + t + timer;

            DateTime startDateTime = new DateTime(a + ":00+07:00");
            EventDateTime start = new EventDateTime()
                    .setDateTime(startDateTime)
                    .setTimeZone("Asia/Bangkok");
            eventH_w12_day5.setStart(start);
            DateTime endDateTime = new DateTime(a + ":00+07:00");
            EventDateTime end = new EventDateTime()
                    .setDateTime(endDateTime)
                    .setTimeZone("Asia/Bangkok");
            eventH_w12_day5.setEnd(end);
            Event createdEvent = client.events().insert("primary", eventH_w12_day5).execute();
            System.out.println("Created event id: " + createdEvent.getId());
        } else {
            String a = yearandmonth + "-" + intvalueday + t + timer;
        }
    }

}



