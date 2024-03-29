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

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;

import library.android.calendar.materialdatetimepicker.com.wdullaer.materialdatetimepicker.AccessibleTextView;
import library.android.calendar.materialdatetimepicker.com.wdullaer.materialdatetimepicker.HapticFeedbackController;
import library.android.calendar.materialdatetimepicker.com.wdullaer.materialdatetimepicker.TypefaceHelper;
import library.android.calendar.materialdatetimepicker.com.wdullaer.materialdatetimepicker.Utils;
import ir.eniac.tech.bimeh.com.sdk.bimeh.R;

/**
 * Dialog allowing users to select a date.
 */
@SuppressLint("ValidFragment")
public class DatePickerDialog extends DialogFragment implements
        OnClickListener, DatePickerController {

    private static final int UNINITIALIZED = -1;
    private static final int MONTH_AND_DAY_VIEW = 0;
    private static final int YEAR_VIEW = 1;

    private static final String KEY_SELECTED_YEAR = "year";
    private static final String KEY_SELECTED_MONTH = "month";
    private static final String KEY_SELECTED_DAY = "day";
    private static final String KEY_LIST_POSITION = "list_position";
    private static final String KEY_WEEK_START = "week_start";
    private static final String KEY_YEAR_START = "year_start";
    private static final String KEY_YEAR_END = "year_end";
    private static final String KEY_CURRENT_VIEW = "current_view";
    private static final String KEY_LIST_POSITION_OFFSET = "list_position_offset";
    private static final String KEY_MIN_DATE = "min_date";
    private static final String KEY_MAX_DATE = "max_date";
    private static final String KEY_HIGHLIGHTED_DAYS = "highlighted_days";
    private static final String KEY_SELECTABLE_DAYS = "selectable_days";
    private static final String KEY_DISABLED_DAYS = "disabled_days";
    private static final String KEY_THEME_DARK = "theme_dark";
    private static final String KEY_THEME_DARK_CHANGED = "theme_dark_changed";
    private static final String KEY_ACCENT = "accent";
    private static final String KEY_VIBRATE = "vibrate";
    private static final String KEY_DISMISS = "dismiss";
    private static final String KEY_AUTO_DISMISS = "auto_dismiss";
    private static final String KEY_DEFAULT_VIEW = "default_view";
    private static final String KEY_TITLE = "title";
    private static final String KEY_OK_RESID = "ok_resid";
    private static final String KEY_OK_STRING = "ok_string";
    private static final String KEY_CANCEL_RESID = "cancel_resid";
    private static final String KEY_CANCEL_STRING = "cancel_string";


    private static final int DEFAULT_START_YEAR = 1900;
    private static final int DEFAULT_END_YEAR = 2100;

    private static final int ANIMATION_DURATION = 300;
    private static final int ANIMATION_DELAY = 500;

    private static SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy", Locale.ENGLISH);
    private static SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("dd", Locale.ENGLISH);

    private final Calendar mCalendar = trimToMidnight(Calendar.getInstance());
    Button switchType;
    int visibile;
    private Calendar mEndCalendar = null;
    private boolean isEndSelectable = false; // range picker or single picker
    private OnDateSetListener mCallBack;
    private HashSet<OnDateChangedListener> mListeners = new HashSet<>();
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private AccessibleDateAnimator mAnimator;
    private TextView mDayOfWeekView;
    private LinearLayout mMonthAndDayView;
    private TextView mSelectedMonthTextView;
    private TextView mSelectedDayTextView;
    private TextView mYearView;
    private DayPickerView mDayPickerView;
    private YearPickerView mYearPickerView;
    private int mCurrentView = UNINITIALIZED;
    private int mWeekStart = mCalendar.getFirstDayOfWeek();
    private int mMinYear = DEFAULT_START_YEAR;
    private int mMaxYear = DEFAULT_END_YEAR;
    private String mTitle;
    private Calendar mMinDate;
    private Calendar mMaxDate;
    private Calendar[] highlightedDays;
    private Calendar[] selectableDays;
    private Calendar[] disabledDays;
    private boolean mThemeDark = false;
    private boolean mThemeDarkChanged = false;
    private int mAccentColor = -1;
    private boolean mVibrate = true;
    private boolean mDismissOnPause = false;
    private boolean mAutoDismiss = false;
    private int mDefaultView = MONTH_AND_DAY_VIEW;
    private int mOkResid = R.string.gmdtp_ok;
    private String mOkString;
    private int mCancelResid = R.string.gmdtp_cancel;
    private String mCancelString;
    private HapticFeedbackController mHapticFeedbackController;
    private boolean mDelayAnimation = true;
    // Accessibility strings.
    private String mDayPickerDescription;
    private String mSelectDay;
    private String mYearPickerDescription;
    private String mSelectYear;
    private OnCalendarChangedListener mOnCalendarChangeListener;

    @SuppressLint("ValidFragment")
    public DatePickerDialog(int visibile) {
        // Empty constructor required for dialog fragment.
        this.visibile = visibile;
    }

    /**
     * @param callBack    How the parent is notified that the date is set.
     * @param year        The initial year of the dialog.
     * @param monthOfYear The initial month of the dialog.
     * @param dayOfMonth  The initial day of the dialog.
     */
    public static DatePickerDialog newInstance(OnDateSetListener callBack, int year,
                                               int monthOfYear,
                                               int dayOfMonth, boolean isEndSelectable) {
        DatePickerDialog ret = new DatePickerDialog(2);
        ret.initialize(callBack, year, monthOfYear, dayOfMonth, isEndSelectable);
        return ret;
    }

    public static String toEnglishString(String charSequence) {
        String number = String.valueOf(charSequence);
        return number.replace("۱", "1").replace("۲", "2").replace("۳", "3").replace("۴", "4").replace("۵", "5").replace("۶", "6").replace("۷", "7").replace("۸", "8").replace("۹", "9")
                .replace("۰", "0");
    }

    public void initialize(OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        mCallBack = callBack;
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, monthOfYear);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }

    public void initialize(OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth, boolean isEndSelectable) {
        mCallBack = callBack;
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, monthOfYear);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        this.isEndSelectable = isEndSelectable;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = getActivity();
        activity.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mCurrentView = UNINITIALIZED;
        if (savedInstanceState != null) {
            mCalendar.set(Calendar.YEAR, savedInstanceState.getInt(KEY_SELECTED_YEAR));
            mCalendar.set(Calendar.MONTH, savedInstanceState.getInt(KEY_SELECTED_MONTH));
            mCalendar.set(Calendar.DAY_OF_MONTH, savedInstanceState.getInt(KEY_SELECTED_DAY));
            mDefaultView = savedInstanceState.getInt(KEY_DEFAULT_VIEW);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SELECTED_YEAR, mCalendar.get(Calendar.YEAR));
        outState.putInt(KEY_SELECTED_MONTH, mCalendar.get(Calendar.MONTH));
        outState.putInt(KEY_SELECTED_DAY, mCalendar.get(Calendar.DAY_OF_MONTH));
        outState.putInt(KEY_WEEK_START, mWeekStart);
        outState.putInt(KEY_YEAR_START, mMinYear);
        outState.putInt(KEY_YEAR_END, mMaxYear);
        outState.putInt(KEY_CURRENT_VIEW, mCurrentView);
        int listPosition = -1;
        if (mCurrentView == MONTH_AND_DAY_VIEW) {
            listPosition = mDayPickerView.getMostVisiblePosition();
        } else if (mCurrentView == YEAR_VIEW) {
            listPosition = mYearPickerView.getFirstVisiblePosition();
            outState.putInt(KEY_LIST_POSITION_OFFSET, mYearPickerView.getFirstPositionOffset());
        }
        outState.putInt(KEY_LIST_POSITION, listPosition);
        outState.putSerializable(KEY_MIN_DATE, mMinDate);
        outState.putSerializable(KEY_MAX_DATE, mMaxDate);
        outState.putSerializable(KEY_HIGHLIGHTED_DAYS, highlightedDays);
        outState.putSerializable(KEY_SELECTABLE_DAYS, selectableDays);
        outState.putSerializable(KEY_DISABLED_DAYS, disabledDays);
        outState.putBoolean(KEY_THEME_DARK, mThemeDark);
        outState.putBoolean(KEY_THEME_DARK_CHANGED, mThemeDarkChanged);
        outState.putInt(KEY_ACCENT, mAccentColor);
        outState.putBoolean(KEY_VIBRATE, mVibrate);
        outState.putBoolean(KEY_DISMISS, mDismissOnPause);
        outState.putBoolean(KEY_AUTO_DISMISS, mAutoDismiss);
        outState.putInt(KEY_DEFAULT_VIEW, mDefaultView);
        outState.putString(KEY_TITLE, mTitle);
        outState.putInt(KEY_OK_RESID, mOkResid);
        outState.putString(KEY_OK_STRING, mOkString);
        outState.putInt(KEY_CANCEL_RESID, mCancelResid);
        outState.putString(KEY_CANCEL_STRING, mCancelString);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // All options have been set at this point: round the initial selection if necessary
        setToNearestDate(mCalendar);

        View view = inflater.inflate(R.layout.gmdtp_date_picker_dialog, container, false);

        mDayOfWeekView = (TextView) view.findViewById(R.id.date_picker_header);
        mMonthAndDayView = (LinearLayout) view.findViewById(R.id.date_picker_month_and_day);
        mMonthAndDayView.setOnClickListener(this);
        mSelectedMonthTextView = (TextView) view.findViewById(R.id.date_picker_month);
        mSelectedDayTextView = (TextView) view.findViewById(R.id.date_picker_day);
        mYearView = (TextView) view.findViewById(R.id.date_picker_year);
        mYearView.setOnClickListener(this);
        switchType = (Button) view.findViewById(R.id.gswitch_type);
        if (visibile == 1) {
            switchType.setVisibility(View.INVISIBLE);
        }
        final AccessibleTextView date_picker_year = (AccessibleTextView) view.findViewById(R.id.date_picker_year);
        date_picker_year.setVisibility(View.VISIBLE);


        int listPosition = -1;
        int listPositionOffset = 0;
        int currentView = mDefaultView;
        if (savedInstanceState != null) {
            mWeekStart = savedInstanceState.getInt(KEY_WEEK_START);
            mMinYear = savedInstanceState.getInt(KEY_YEAR_START);
            mMaxYear = savedInstanceState.getInt(KEY_YEAR_END);
            currentView = savedInstanceState.getInt(KEY_CURRENT_VIEW);
            listPosition = savedInstanceState.getInt(KEY_LIST_POSITION);
            listPositionOffset = savedInstanceState.getInt(KEY_LIST_POSITION_OFFSET);
            mMinDate = (Calendar) savedInstanceState.getSerializable(KEY_MIN_DATE);
            mMaxDate = (Calendar) savedInstanceState.getSerializable(KEY_MAX_DATE);
            highlightedDays = (Calendar[]) savedInstanceState.getSerializable(KEY_HIGHLIGHTED_DAYS);
            selectableDays = (Calendar[]) savedInstanceState.getSerializable(KEY_SELECTABLE_DAYS);
            disabledDays = (Calendar[]) savedInstanceState.getSerializable(KEY_DISABLED_DAYS);
            mThemeDark = savedInstanceState.getBoolean(KEY_THEME_DARK);
            mThemeDarkChanged = savedInstanceState.getBoolean(KEY_THEME_DARK_CHANGED);
            mAccentColor = savedInstanceState.getInt(KEY_ACCENT);
            mVibrate = savedInstanceState.getBoolean(KEY_VIBRATE);
            mDismissOnPause = savedInstanceState.getBoolean(KEY_DISMISS);
            mAutoDismiss = savedInstanceState.getBoolean(KEY_AUTO_DISMISS);
            mTitle = savedInstanceState.getString(KEY_TITLE);
            mOkResid = savedInstanceState.getInt(KEY_OK_RESID);
            mOkString = savedInstanceState.getString(KEY_OK_STRING);
            mCancelResid = savedInstanceState.getInt(KEY_CANCEL_RESID);
            mCancelString = savedInstanceState.getString(KEY_CANCEL_STRING);
        }

        final Activity activity = getActivity();
        mDayPickerView = new SimpleDayPickerView(activity, this);
        mYearPickerView = new YearPickerView(activity, this);

        // if theme mode has not been set by java code, check if it is specified in Style.xml
        if (!mThemeDarkChanged) {
            mThemeDark = Utils.isDarkTheme(activity, mThemeDark);
        }

        Resources res = getResources();
        mDayPickerDescription = res.getString(R.string.mdtp_day_picker_description);
        mSelectDay = res.getString(R.string.mdtp_select_day);
        mYearPickerDescription = res.getString(R.string.mdtp_year_picker_description);
        mSelectYear = res.getString(R.string.mdtp_select_year);

        int bgColorResource = mThemeDark ? R.color.mdtp_date_picker_view_animator_dark_theme : R.color.mdtp_date_picker_view_animator;
        view.setBackgroundColor(ContextCompat.getColor(activity, bgColorResource));

        mAnimator = (AccessibleDateAnimator) view.findViewById(R.id.animator);
        mAnimator.addView(mDayPickerView);
        mAnimator.addView(mYearPickerView);
        mAnimator.setDateMillis(mCalendar.getTimeInMillis());
        // TODO: Replace with animation decided upon by the design team.
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(ANIMATION_DURATION);
        mAnimator.setInAnimation(animation);
        // TODO: Replace with animation decided upon by the design team.
        Animation animation2 = new AlphaAnimation(1.0f, 0.0f);
        animation2.setDuration(ANIMATION_DURATION);
        mAnimator.setOutAnimation(animation2);

        Button okButton = (Button) view.findViewById(R.id.ok);
        okButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                tryVibrate();
                if (isEndSelectable && mEndCalendar == null) {
                    Toast.makeText(getActivity(), "Please select return date", Toast.LENGTH_SHORT).show();
                    return;
                }
                notifyOnDateListener();
                dismiss();
            }
        });
        okButton.setTypeface(TypefaceHelper.get(activity, "Roboto-Medium"));
        mSelectedDayTextView.setTypeface(TypefaceHelper.get(activity, "Roboto-Medium"));
        mYearView.setTypeface(TypefaceHelper.get(activity, "Roboto-Medium"));
        if (mOkString != null) okButton.setText(toEnglishString(mOkString));
        else okButton.setText(mOkResid);

        Button cancelButton = (Button) view.findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tryVibrate();
                if (getDialog() != null) getDialog().cancel();
            }
        });

        switchType.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnCalendarChangeListener != null)
                    mOnCalendarChangeListener.onCalendarChanged(false);
                getDialog().cancel();
            }
        });
//        switchType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    if(mOnCalendarChangeListener!= null)
//                        mOnCalendarChangeListener.onCalendarChanged(false);
//                    getDialog().cancel();
//                    switchType.setChecked(false);
//                }
//            }
//        });
        switchType.setTypeface(TypefaceHelper.get(activity, "Roboto-Medium"));
        cancelButton.setTypeface(TypefaceHelper.get(activity, "Roboto-Medium"));
        if (mCancelString != null) cancelButton.setText(mCancelString);
        else cancelButton.setText(mCancelResid);
        cancelButton.setVisibility(isCancelable() ? View.VISIBLE : View.GONE);

        // If an accent color has not been set manually, get it from the context
        if (mAccentColor == -1) {
            mAccentColor = Utils.getAccentColorFromThemeIfAvailable(getActivity());
        }
        if (mDayOfWeekView != null)
            mDayOfWeekView.setBackgroundColor(Utils.darkenColor(mAccentColor));
        view.findViewById(R.id.day_picker_selected_date_layout).setBackgroundColor(mAccentColor);
        okButton.setTextColor(mAccentColor);
        cancelButton.setTextColor(mAccentColor);

        if (getDialog() == null) {
            view.findViewById(R.id.done_background).setVisibility(View.GONE);
        }

        updateDisplay(false);
        setCurrentView(currentView);

        if (listPosition != -1) {
            if (currentView == MONTH_AND_DAY_VIEW) {
                mDayPickerView.postSetSelection(listPosition);
            } else if (currentView == YEAR_VIEW) {
                mYearPickerView.postSetSelectionFromTop(listPosition, listPositionOffset);
            }
        }

        mHapticFeedbackController = new HapticFeedbackController(activity);
        return view;
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
            View view = onCreateView(getActivity().getLayoutInflater(), viewGroup, null);
            viewGroup.addView(view);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();
        mHapticFeedbackController.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mHapticFeedbackController.stop();
        if (mDismissOnPause) dismiss();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (mOnCancelListener != null) mOnCancelListener.onCancel(dialog);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mOnDismissListener != null) mOnDismissListener.onDismiss(dialog);
    }

    private void setCurrentView(final int viewIndex) {
        long millis = mCalendar.getTimeInMillis();

        switch (viewIndex) {
            case MONTH_AND_DAY_VIEW:
                ObjectAnimator pulseAnimator = Utils.getPulseAnimator(mMonthAndDayView, 0.9f,
                        1.05f);
                if (mDelayAnimation) {
                    pulseAnimator.setStartDelay(ANIMATION_DELAY);
                    mDelayAnimation = false;
                }
                mDayPickerView.onDateChanged();
                if (mCurrentView != viewIndex) {
                    mMonthAndDayView.setSelected(true);
                    mYearView.setSelected(false);
                    mAnimator.setDisplayedChild(MONTH_AND_DAY_VIEW);
                    mCurrentView = viewIndex;
                }
                pulseAnimator.start();

                int flags = DateUtils.FORMAT_SHOW_DATE;
                String dayString = DateUtils.formatDateTime(getActivity(), millis, flags);
                mAnimator.setContentDescription(mDayPickerDescription + ": " + dayString);
                Utils.tryAccessibilityAnnounce(mAnimator, mSelectDay);
                break;
            case YEAR_VIEW:
                pulseAnimator = Utils.getPulseAnimator(mYearView, 0.85f, 1.1f);
                if (mDelayAnimation) {
                    pulseAnimator.setStartDelay(ANIMATION_DELAY);
                    mDelayAnimation = false;
                }
                mYearPickerView.onDateChanged();
                if (mCurrentView != viewIndex) {
                    mMonthAndDayView.setSelected(false);
                    mYearView.setSelected(true);
                    mAnimator.setDisplayedChild(YEAR_VIEW);
                    mCurrentView = viewIndex;
                }
                pulseAnimator.start();

                CharSequence yearString = YEAR_FORMAT.format(millis);
                mAnimator.setContentDescription(mYearPickerDescription + ": " + yearString);
                Utils.tryAccessibilityAnnounce(mAnimator, mSelectYear);
                break;
        }
    }

    private void updateDisplay(boolean announce) {
        if (mDayOfWeekView != null) {
            if (mTitle != null)
                mDayOfWeekView.setText(toEnglishString(mTitle.toUpperCase(Locale.ENGLISH)));
            else {
                mDayOfWeekView.setText(toEnglishString(mCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG,
                        Locale.ENGLISH)).toUpperCase(Locale.ENGLISH));
            }
        }

        mSelectedMonthTextView.setText(toEnglishString(mCalendar.getDisplayName(Calendar.MONTH, Calendar.SHORT,
                Locale.ENGLISH)).toUpperCase(Locale.ENGLISH));
        mSelectedDayTextView.setText(toEnglishString(DAY_FORMAT.format(mCalendar.getTime())));
        mYearView.setText(toEnglishString(YEAR_FORMAT.format(mCalendar.getTime())));

        // Accessibility.
        long millis = mCalendar.getTimeInMillis();
        mAnimator.setDateMillis(millis);
        int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NO_YEAR;
        String monthAndDayText = DateUtils.formatDateTime(getActivity(), millis, flags);
        mMonthAndDayView.setContentDescription(monthAndDayText);

        if (announce) {
            flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR;
            String fullDateText = DateUtils.formatDateTime(getActivity(), millis, flags);
            Utils.tryAccessibilityAnnounce(mAnimator, fullDateText);
        }
    }

    /**
     * Set whether the device should vibrate when touching fields
     *
     * @param vibrate true if the device should vibrate when touching a field
     */
    public void vibrate(boolean vibrate) {
        mVibrate = vibrate;
    }

    /**
     * Set whether the picker should dismiss itself when being paused or whether it should try to survive an orientation change
     *
     * @param dismissOnPause true if the dialog should dismiss itself when it's pausing
     */
    public void dismissOnPause(boolean dismissOnPause) {
        mDismissOnPause = dismissOnPause;
    }

    /**
     * Set whether the picker should dismiss itself when a day is selected
     *
     * @param autoDismiss true if the dialog should dismiss itself when a day is selected
     */
    @SuppressWarnings("unused")
    public void autoDismiss(boolean autoDismiss) {
        mAutoDismiss = autoDismiss;
    }

    /**
     * Returns true when the dark theme should be used
     *
     * @return true if the dark theme should be used, false if the default theme should be used
     */
    @Override
    public boolean isThemeDark() {
        return mThemeDark;
    }

    /**
     * Set whether the dark theme should be used
     *
     * @param themeDark true if the dark theme should be used, false if the default theme should be used
     */
    public void setThemeDark(boolean themeDark) {
        mThemeDark = themeDark;
        mThemeDarkChanged = true;
    }

    /**
     * Set the accent color of this dialog
     *
     * @param color the accent color you want
     */
    @SuppressWarnings("unused")
    public void setAccentColor(String color) {
        mAccentColor = Color.parseColor(color);
    }

    /**
     * Get the accent color of this dialog
     *
     * @return accent color
     */
    @Override
    public int getAccentColor() {
        return mAccentColor;
    }

    /**
     * Set the accent color of this dialog
     *
     * @param color the accent color you want
     */
    public void setAccentColor(@ColorInt int color) {
        mAccentColor = Color.argb(255, Color.red(color), Color.green(color), Color.blue(color));
    }

    /**
     * Set whether the year picker of the month and day picker is shown first
     *
     * @param yearPicker boolean
     */
    public void showYearPickerFirst(boolean yearPicker) {
        mDefaultView = yearPicker ? YEAR_VIEW : MONTH_AND_DAY_VIEW;
    }

    @SuppressWarnings("unused")
    public void setYearRange(int startYear, int endYear) {
        if (endYear < startYear) {
            throw new IllegalArgumentException("Year end must be larger than or equal to year start");
        }

        mMinYear = startYear;
        mMaxYear = endYear;
        if (mDayPickerView != null) {
            mDayPickerView.onChange();
        }
    }

    /**
     * @return The minimal date supported by this DatePicker. Null if it has not been set.
     */
    @SuppressWarnings("unused")
    public Calendar getMinDate() {
        return mMinDate;
    }

    /**
     * Sets the minimal date supported by this DatePicker. Dates before (but not including) the
     * specified date will be disallowed from being selected.
     *
     * @param calendar a Calendar object set to the year, month, day desired as the mindate.
     */
    @SuppressWarnings("unused")
    public void setMinDate(Calendar calendar) {
        mMinDate = trimToMidnight(calendar);

        if (mDayPickerView != null) {
            mDayPickerView.onChange();
        }
    }

    /**
     * @return The maximal date supported by this DatePicker. Null if it has not been set.
     */
    @SuppressWarnings("unused")
    public Calendar getMaxDate() {
        return mMaxDate;
    }

    /**
     * Sets the minimal date supported by this DatePicker. Dates after (but not including) the
     * specified date will be disallowed from being selected.
     *
     * @param calendar a Calendar object set to the year, month, day desired as the maxdate.
     */
    @SuppressWarnings("unused")
    public void setMaxDate(Calendar calendar) {
        mMaxDate = trimToMidnight(calendar);

        if (mDayPickerView != null) {
            mDayPickerView.onChange();
        }
    }

    public void setEndCalendar(int year, int month, int day) {
        if (mEndCalendar == null) mEndCalendar = Calendar.getInstance();
        mEndCalendar.set(Calendar.YEAR, year);
        mEndCalendar.set(Calendar.MONTH, month);
        mEndCalendar.set(Calendar.DAY_OF_MONTH, day);
    }

    public void clearEndCalendar() {
        mEndCalendar = null;
    }

    public void setCalendar(int year, int month, int day) {
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public MonthAdapter.CalendarDay getEndSelectedDay() {
        if (mEndCalendar == null) return null;
        return new MonthAdapter.CalendarDay(mEndCalendar);
    }

    /**
     * @return The list of dates, as Calendar Objects, which should be highlighted. null is no dates should be highlighted
     */
    @Override
    public Calendar[] getHighlightedDays() {
        return highlightedDays;
    }

    /**
     * Sets an array of dates which should be highlighted when the picker is drawn
     *
     * @param highlightedDays an Array of Calendar objects containing the dates to be highlighted
     */
    @SuppressWarnings("unused")
    public void setHighlightedDays(Calendar[] highlightedDays) {
        Arrays.sort(highlightedDays);
        for (Calendar highlightedDay : highlightedDays) trimToMidnight(highlightedDay);
        this.highlightedDays = highlightedDays;
        if (mDayPickerView != null) mDayPickerView.onChange();
    }

    /**
     * @return an Array of Calendar objects containing the list with selectable items. null if no restriction is set
     */
    @SuppressWarnings("unused")
    public Calendar[] getSelectableDays() {
        return selectableDays;
    }

    /**
     * Sets a list of days which are the only valid selections.
     * Setting this value will take precedence over using setMinDate() and setMaxDate()
     *
     * @param selectableDays an Array of Calendar Objects containing the selectable dates
     */
    @SuppressWarnings("unused")
    public void setSelectableDays(Calendar[] selectableDays) {
        Arrays.sort(selectableDays);
        for (Calendar selectableDay : selectableDays) trimToMidnight(selectableDay);
        this.selectableDays = selectableDays;
        if (mDayPickerView != null) mDayPickerView.onChange();
    }

    /**
     * @return an Array of Calendar objects containing the list of days that are not selectable. null if no restriction is set
     */
    @SuppressWarnings("unused")
    public Calendar[] getDisabledDays() {
        return disabledDays;
    }

    /**
     * Sets a list of days that are not selectable in the picker
     * Setting this value will take precedence over using setMinDate() and setMaxDate(), but stacks with setSelectableDays()
     *
     * @param disabledDays an Array of Calendar Objects containing the disabled dates
     */
    @SuppressWarnings("unused")
    public void setDisabledDays(Calendar[] disabledDays) {
        Arrays.sort(disabledDays);
        for (Calendar disabledDay : disabledDays) trimToMidnight(disabledDay);
        this.disabledDays = disabledDays;
        if (mDayPickerView != null) mDayPickerView.onChange();
    }

    /**
     * Set a title to be displayed instead of the weekday
     *
     * @param title String - The title to be displayed
     */
    public void setTitle(String title) {
        mTitle = title;
    }

    /**
     * Set the label for the Ok button (max 12 characters)
     *
     * @param okString A literal String to be used as the Ok button label
     */
    @SuppressWarnings("unused")
    public void setOkText(String okString) {
        mOkString = okString;
    }

    /**
     * Set the label for the Ok button (max 12 characters)
     *
     * @param okResid A resource ID to be used as the Ok button label
     */
    @SuppressWarnings("unused")
    public void setOkText(@StringRes int okResid) {
        mOkString = null;
        mOkResid = okResid;
    }

    /**
     * Set the label for the Cancel button (max 12 characters)
     *
     * @param cancelString A literal String to be used as the Cancel button label
     */
    @SuppressWarnings("unused")
    public void setCancelText(String cancelString) {
        mCancelString = cancelString;
    }

    /**
     * Set the label for the Cancel button (max 12 characters)
     *
     * @param cancelResid A resource ID to be used as the Cancel button label
     */
    @SuppressWarnings("unused")
    public void setCancelText(@StringRes int cancelResid) {
        mCancelString = null;
        mCancelResid = cancelResid;
    }

    @SuppressWarnings("unused")
    public void setOnDateSetListener(OnDateSetListener listener) {
        mCallBack = listener;
    }

    @SuppressWarnings("unused")
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        mOnCancelListener = onCancelListener;
    }

    @SuppressWarnings("unused")
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        mOnDismissListener = onDismissListener;
    }

    public void setOnCalandarChangeListener(OnCalendarChangedListener onCalandarChangeListener) {
        mOnCalendarChangeListener = onCalandarChangeListener;
    }

    // If the newly selected month / year does not contain the currently selected day number,
    // change the selected day number to the last day of the selected month or year.
    //      e.g. Switching from Mar to Apr when Mar 31 is selected -> Apr 30
    //      e.g. Switching from 2012 to 2013 when Feb 29, 2012 is selected -> Feb 28, 2013
    private void adjustDayInMonthIfNeeded(Calendar calendar) {
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day > daysInMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, daysInMonth);
        }
        setToNearestDate(calendar);
    }

    @Override
    public void onClick(View v) {
        tryVibrate();
        if (v.getId() == R.id.date_picker_year) {
            setCurrentView(YEAR_VIEW);
        } else if (v.getId() == R.id.date_picker_month_and_day) {
            setCurrentView(MONTH_AND_DAY_VIEW);
        }
    }

    @Override
    public void onYearSelected(int year) {
        mCalendar.set(Calendar.YEAR, year);
        adjustDayInMonthIfNeeded(mCalendar);
        updatePickers();
        setCurrentView(MONTH_AND_DAY_VIEW);
        updateDisplay(true);
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day) {
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, day);
        mEndCalendar = null;
        updatePickers();
        updateDisplay(true);
        if (mAutoDismiss) {
            notifyOnDateListener();
            dismiss();
        }
    }

    @Override
    public boolean isEndSelectable() {
        return isEndSelectable;
    }

    public void setEndSelectable(boolean isEndSelectable) {
        this.isEndSelectable = isEndSelectable;
    }

    @Override
    public void onEndDayOfMonthSelected(int year, int month, int day) {
        if (mEndCalendar == null) mEndCalendar = Calendar.getInstance();
        mEndCalendar.set(Calendar.YEAR, year);
        mEndCalendar.set(Calendar.MONTH, month);
        mEndCalendar.set(Calendar.DAY_OF_MONTH, day);
//        updatePickers();
//        String monthAndDayText = LanguageUtils.getPersianNumbers(
//                mPersianCalendar.getPersianDay() + " " +
//                        mPersianCalendar.getPersianMonthName()
//
//        );
//        String emonthAndDayText = LanguageUtils.getPersianNumbers(
//                mEndPersianCalendar.getPersianDay() + " " +
//                        mEndPersianCalendar.getPersianMonthName()
//        );
//        mHintView.setText(monthAndDayText+" به "+ emonthAndDayText);
        updateDisplay(true);
    }

    private void updatePickers() {
        for (OnDateChangedListener listener : mListeners) listener.onDateChanged();
    }

    @Override
    public MonthAdapter.CalendarDay getSelectedDay() {
        return new MonthAdapter.CalendarDay(mCalendar);
    }

    @Override
    public Calendar getStartDate() {
        if (selectableDays != null) return selectableDays[0];
        if (mMinDate != null) return mMinDate;
        Calendar output = Calendar.getInstance();
        output.set(Calendar.YEAR, mMinYear);
        output.set(Calendar.DAY_OF_MONTH, 1);
        output.set(Calendar.MONTH, Calendar.JANUARY);
        return output;
    }

    @Override
    public Calendar getEndDate() {
        if (selectableDays != null) return selectableDays[selectableDays.length - 1];
        if (mMaxDate != null) return mMaxDate;
        Calendar output = Calendar.getInstance();
        output.set(Calendar.YEAR, mMaxYear);
        output.set(Calendar.DAY_OF_MONTH, 31);
        output.set(Calendar.MONTH, Calendar.DECEMBER);
        return output;
    }

    @Override
    public int getMinYear() {
        if (selectableDays != null) return selectableDays[0].get(Calendar.YEAR);
        // Ensure no years can be selected outside of the given minimum date
        return mMinDate != null && mMinDate.get(Calendar.YEAR) > mMinYear ? mMinDate.get(Calendar.YEAR) : mMinYear;
    }

    @Override
    public int getMaxYear() {
        if (selectableDays != null)
            return selectableDays[selectableDays.length - 1].get(Calendar.YEAR);
        // Ensure no years can be selected outside of the given maximum date
        return mMaxDate != null && mMaxDate.get(Calendar.YEAR) < mMaxYear ? mMaxDate.get(Calendar.YEAR) : mMaxYear;
    }

    /**
     * @return true if the specified year/month/day are within the selectable days or the range set by minDate and maxDate.
     * If one or either have not been set, they are considered as Integer.MIN_VALUE and
     * Integer.MAX_VALUE.
     */
    @Override
    public boolean isOutOfRange(int year, int month, int day) {
        return isDisabled(year, month, day) || !isSelectable(year, month, day);
    }

    @SuppressWarnings("unused")
    public boolean isOutOfRange(Calendar calendar) {
        return isOutOfRange(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    private boolean isDisabled(int year, int month, int day) {
        return containsDate(disabledDays, year, month, day) || isBeforeMin(year, month, day) || isAfterMax(year, month, day);
    }

    private boolean isDisabled(Calendar c) {
        return isDisabled(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    }

    private boolean isSelectable(int year, int month, int day) {
        return selectableDays == null || containsDate(selectableDays, year, month, day);
    }

    /**
     * Checks whether the given data is contained in an array of dates
     *
     * @param dates Calendar[] which contents we want to search_locations_mock
     * @param year  the year as an int
     * @param month the month as an int
     * @param day   the day as an int
     * @return true if the data is present in the array
     */
    private boolean containsDate(Calendar[] dates, int year, int month, int day) {
        if (dates == null) return false;
        for (Calendar c : dates) {
            if (year < c.get(Calendar.YEAR)) break;
            if (year > c.get(Calendar.YEAR)) continue;
            if (month < c.get(Calendar.MONTH)) break;
            if (month > c.get(Calendar.MONTH)) continue;
            if (day < c.get(Calendar.DAY_OF_MONTH)) break;
            if (day > c.get(Calendar.DAY_OF_MONTH)) continue;
            return true;
        }
        return false;
    }

    private boolean isBeforeMin(int year, int month, int day) {
        if (mMinDate == null) {
            return false;
        }

        if (year < mMinDate.get(Calendar.YEAR)) {
            return true;
        } else if (year > mMinDate.get(Calendar.YEAR)) {
            return false;
        }

        if (month < mMinDate.get(Calendar.MONTH)) {
            return true;
        } else if (month > mMinDate.get(Calendar.MONTH)) {
            return false;
        }

        return day < mMinDate.get(Calendar.DAY_OF_MONTH);
    }

    private boolean isBeforeMin(Calendar calendar) {
        return isBeforeMin(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
    }

    private boolean isAfterMax(int year, int month, int day) {
        if (mMaxDate == null) {
            return false;
        }

        if (year > mMaxDate.get(Calendar.YEAR)) {
            return true;
        } else if (year < mMaxDate.get(Calendar.YEAR)) {
            return false;
        }

        if (month > mMaxDate.get(Calendar.MONTH)) {
            return true;
        } else if (month < mMaxDate.get(Calendar.MONTH)) {
            return false;
        }

        return day > mMaxDate.get(Calendar.DAY_OF_MONTH);
    }

    private boolean isAfterMax(Calendar calendar) {
        return isAfterMax(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
    }

    private void setToNearestDate(Calendar calendar) {
        if (selectableDays != null) {
            long distance = Long.MAX_VALUE;
            Calendar currentBest = calendar;
            for (Calendar c : selectableDays) {
                long newDistance = Math.abs(calendar.getTimeInMillis() - c.getTimeInMillis());
                if (newDistance < distance && !isDisabled(c)) {
                    distance = newDistance;
                    currentBest = c;
                } else break;
            }
            calendar.setTimeInMillis(currentBest.getTimeInMillis());
            return;
        }

        if (disabledDays != null) {
            Calendar forwardDate = (Calendar) calendar.clone();
            Calendar backwardDate = (Calendar) calendar.clone();
            while (isDisabled(forwardDate) && isDisabled(backwardDate)) {
                forwardDate.add(Calendar.DAY_OF_MONTH, 1);
                backwardDate.add(Calendar.DAY_OF_MONTH, -1);
            }
            if (!isDisabled(backwardDate)) {
                calendar.setTimeInMillis(backwardDate.getTimeInMillis());
                return;
            }
            if (!isDisabled(forwardDate)) {
                calendar.setTimeInMillis(forwardDate.getTimeInMillis());
                return;
            }
        }


        if (isBeforeMin(calendar)) {
            calendar.setTimeInMillis(mMinDate.getTimeInMillis());
            return;
        }

        if (isAfterMax(calendar)) {
            calendar.setTimeInMillis(mMaxDate.getTimeInMillis());
            return;
        }
    }

    /**
     * Trims off all time information, effectively setting it to midnight
     * Makes it easier to compare at just the day level
     *
     * @param calendar The Calendar object to trim
     * @return The trimmed Calendar object
     */
    private Calendar trimToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    @Override
    public int getFirstDayOfWeek() {
        return mWeekStart;
    }

    @SuppressWarnings("unused")
    public void setFirstDayOfWeek(int startOfWeek) {
        if (startOfWeek < Calendar.SUNDAY || startOfWeek > Calendar.SATURDAY) {
            throw new IllegalArgumentException("Value must be between Calendar.SUNDAY and " +
                    "Calendar.SATURDAY");
        }
        mWeekStart = startOfWeek;
        if (mDayPickerView != null) {
            mDayPickerView.onChange();
        }
    }

    @Override
    public void registerOnDateChangedListener(OnDateChangedListener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterOnDateChangedListener(OnDateChangedListener listener) {
        mListeners.remove(listener);
    }

    @Override
    public void tryVibrate() {
        if (mVibrate) mHapticFeedbackController.tryVibrate();
    }

    public void notifyOnDateListener() {
        if (mCallBack != null) {
            mCallBack.onDateSet(DatePickerDialog.this, mCalendar.get(Calendar.YEAR),
                    mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH),
                    mEndCalendar == null ? 0 : mEndCalendar.get(Calendar.YEAR),
                    mEndCalendar == null ? 0 : mEndCalendar.get(Calendar.MONTH),
                    mEndCalendar == null ? 0 : mEndCalendar.get(Calendar.DAY_OF_MONTH));
        }
    }

    /**
     * The callback used to indicate the user is done filling in the date.
     */
    public interface OnDateSetListener {

        /**
         * @param view        The view associated with this listener.
         * @param year        The year that was set.
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int endYear, int endMonth, int endDay);
    }

    /**
     * The callback used to notify other date picker components of a change in selected date.
     */
    public interface OnDateChangedListener {

        void onDateChanged();
    }

    public interface OnCalendarChangedListener {

        void onCalendarChanged(boolean isGregorian);
    }
}
