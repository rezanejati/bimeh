/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package library.android.calendar.materialdatetimepicker.com.wdullaer.materialdatetimepicker.date;

import java.util.Calendar;

/**
 * Controller class to communicate among the various components of the date picker dialog.
 */
public interface DatePickerController {

    void onYearSelected(int year);

    void onDayOfMonthSelected(int year, int month, int day);
    void onEndDayOfMonthSelected(int year, int month, int day);
    boolean isEndSelectable();

    void registerOnDateChangedListener(DatePickerDialog.OnDateChangedListener listener);

    void unregisterOnDateChangedListener(DatePickerDialog.OnDateChangedListener listener);

    MonthAdapter.CalendarDay getSelectedDay();
    MonthAdapter.CalendarDay getEndSelectedDay();

    boolean isThemeDark();

    int getAccentColor();
    
    Calendar[] getHighlightedDays();

    int getFirstDayOfWeek();

    int getMinYear();

    int getMaxYear();

    Calendar getStartDate();

    Calendar getEndDate();

    boolean isOutOfRange(int year, int month, int day);

    void tryVibrate();
}
