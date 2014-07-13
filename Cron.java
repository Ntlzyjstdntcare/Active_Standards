

/**
* @author 
* <ul>
* <li>Colm Ginty     <cginty@tcd.ie> 
* </ul>    
* @version    1.1
*/
public class Cron 
{
    private final String seconds;
    private final String minutes;
    private final String hours;
    private final String dayOfMonth;
    private final String month;
    private final String dayOfWeek;
    private final String year;
	
	
    /**
    * Constructor for Cron instances.
    * <p>
    * Creates new Cron instance with class variables initialised
    * to the values specified in the parameters to the CronConstructor
    * setter methods.
    * </p> 
    */
    private Cron(CronConstructor c) 
    {
        seconds = c.seconds;
        minutes = c.minutes;
        hours = c.hours;
        dayOfMonth = c.dayOfMonth;
        month = c.month;
        dayOfWeek = c.dayOfWeek;
        year = c.year;
    }
	
    /**
    * Inner class for building Cron Objects. 
    * <p>
    * allows us to create a Cron object, with the class variables
    * set by the parameters to the setter methods of the inner class.
    * </p>
    */
    static class CronConstructor 
    {      
        private String seconds;
        private String minutes;
        private String hours;
        private String dayOfMonth;
        private String month;
        private String dayOfWeek;
        private String year;
		
        private int lastLength = 4;

        /**
        * Default constructor for CronConstructor instances.
        */
        public CronConstructor() {}
     
        /**
        * Setter method for seconds value of Cron.
        * <p>
        * As with all the setter methods, it uses a very crude form of input validation
        * that is ugly besides being inaccurate. The use of a regex is needed, but this
        * is currently beyond my capabilities.
        * </p>
        * @param String value that the user wishes to set for the Cron seconds field.
        * @return a CronConstructor instance with the value for the seconds field updated.
        */
        public CronConstructor secondsAre(String seconds) 
        {
            String s = seconds;
            boolean validChar = true;
			
            //If 'UNTIL' is present, replace it with '-'.
            //If AND is present, replace it with ','.
            //If ALL is present, replace it with '*'.
            //If FROM EVERY is present, delete those words, 
            //then find the numbers and insert '/' between them.
            if (seconds.contains("UNTIL"))
            {
                s = s.replace("UNTIL", "-");
            }
            if (seconds.contains("AND"))	
            {
                s = s.replace("AND", ",");
            }
            if (seconds.contains("ALL"))
            {
                s = s.replace("ALL", "*");
            }
            if (seconds.contains("FROM"))
            {
                s = s.replace("FROM", "");
                s = s.replace("EVERY", "/");				
            }
			
            //Need regex here but currently beyond my abilities.
            for (int i = 0; i < s.length(); i++)
            {
                if ((s.charAt(i) == '/') || (s.charAt(i) == '*') || (s.charAt(i) == ',') || (s.charAt(i) == '-') 
                || (s.charAt(i) == '0') || (s.charAt(i) == '1') || (s.charAt(i) == '2') || (s.charAt(i) == '3') || (s.charAt(i) == '4')
                || (s.charAt(i) == '5')	|| (s.charAt(i) == '6') || (s.charAt(i) == '7') || (s.charAt(i) == '8') || (s.charAt(i) == '9'))
                {
                    validChar = true;					
                } else
                {
                    validChar = false;
                    break;
                }
            }
			
            if (validChar == false)
            {
                s = "invalid_input";
            }
			
            this.seconds = s + " ";
            return this;
        }

        /**
        * Setter method for minutes value of Cron.
        * @param String value that the user wishes to set for the Cron minutes field.
        * @return a CronConstructor instance with the value for the minutes field updated.
        */
        public CronConstructor minutesAre(String minutes) 
        {
            String m = minutes;
            boolean validChar = true;
			
            //If 'UNTIL' is present, replace it with '-'.
            //If AND is present, replace it with ','.
            //If ALL is present, replace it with '*'.
            //If FROM EVERY is present, delete those words, 
            //then find the numbers and insert '/' between them.
            if (minutes.contains("UNTIL"))
            {
	            m = m.replace("UNTIL", "-");
            }
                if (minutes.contains("AND"))	
            {
	            m = m.replace("AND", ",");
            }
            if (minutes.contains("ALL"))
            {
	            m = m.replace("ALL", "*");
            }
            if (minutes.contains("FROM"))
            {
	            m = m.replace("FROM", "");
	            m = m.replace("EVERY", "/");				
            }				

            //Crude input validation.
            for (int i = 0; i < m.length(); i++)
            {
	            if ((m.charAt(i) == '/') || (m.charAt(i) == '*') || (m.charAt(i) == ',') || (m.charAt(i) == '-') 
	            || (m.charAt(i) == '0') || (m.charAt(i) == '1') || (m.charAt(i) == '2') || (m.charAt(i) == '3') || (m.charAt(i) == '4')
	            || (m.charAt(i) == '5') || (m.charAt(i) == '6') || (m.charAt(i) == '7') || (m.charAt(i) == '8') || (m.charAt(i) == '9'))
	            {
		            validChar = true;
		
	            } else
	            {
		            validChar = false;
		            break;
	            }
            }

            if (validChar == false)
            {
	            m = "invalid_input";
            }

            this.minutes = m + " ";
            return this;
        }

        /**
        * Setter method for hours value of Cron.
        * @param String value that the user wishes to set for the Cron hours field.
        * @return a CronConstructor instance with the value for the hours field updated.
        */
        public CronConstructor hoursAre(String hours)  
        {
            String h = hours;
            boolean validChar = true;

            //If 'UNTIL' is present, replace it with '-'.
            //If AND is present, replace it with ','.
            //If ALL is present, replace it with '*'.
            //If FROM EVERY is present, delete those words, 
            //then find the numbers and insert '/' between them.
            if (hours.contains("UNTIL"))
            {
	            h = h.replace("UNTIL", "-");
            }
			if ((hours.contains("AND")))	
            {
	            h = h.replace("AND", ",");
            }
			if ((hours.contains("ALL")))
            {
	            h = h.replace("ALL", "*");
            } 
			if (hours.contains("FROM"))
            {
	            h = h.replace("FROM", "");
	            h = h.replace("EVERY", "/");				
            }	

            //Crude input validation.
            for (int i = 0; i < h.length(); i++)
            {
	            if ((h.charAt(i) == '/') || (h.charAt(i) == '*') || (h.charAt(i) == ',') || (h.charAt(i) == '-') 
	            || (h.charAt(i) == '0') || (h.charAt(i) == '1') || (h.charAt(i) == '2') || (h.charAt(i) == '3') || (h.charAt(i) == '4')
	            || (h.charAt(i) == '5') || (h.charAt(i) == '6') || (h.charAt(i) == '7') || (h.charAt(i) == '8') || (h.charAt(i) == '9'))
	            {
		            validChar = true;
		
	            } else
	            {
		            validChar = false;
		            break;
	            }
            }

            if (validChar == false)
            {
	            h = "invalid_input";
            }			

            this.hours = h + " ";
            return this;
        }

        /**
        * Setter method for day of month value of Cron.
        * @param String value that the user wishes to set for the Cron day of month field.
        * @return a CronConstructor instance with the value for the day of month field updated.
        */
        public CronConstructor daysOfMonthAre(String dayOfMonth)  
        {
            String dm = dayOfMonth;
            boolean validChar = true;

            //If 'UNTIL' is present, replace it with '-'.
            //If AND is present, replace it with ','.
            //If ALL is present, replace it with '*'.
            //If FROM EVERY is present, delete those words, 
            //then find the numbers and insert '/' between them.
            //If NONESPECIFIED is present, replace it with '?'.
            //If LAST, and only LAST, is present, replace with 'L'.
            //If LAST is not all, and the second character after the 
            //'T' is 'I', then replace LAST with 'L', and MINUS
            //with '-'.
            //If NEARESTWEEKDAY is present, replace with 'W'.
            if (dayOfMonth.contains("UNTIL"))
            {
                dm = dm.replace("UNTIL", "-");
            }
            if ((dayOfMonth.contains("AND")))	
            {
                dm = dm.replace("AND", ",");
            }
            if ((dayOfMonth.contains("ALL")))
            {
                dm = dm.replace("ALL", "*");
            }
            if (dayOfMonth.contains("FROM"))
            {
                dm = dm.replace("FROM", "");
                dm = dm.replace("EVERY", "/");				
            }
            if ((dayOfMonth.contains("NONESPECIFIED")))
            {
                dm = dm.replace("NONESPECIFIED", "?");
            }
            if ((dayOfMonth.contains("LAST") && (dayOfMonth.length() == lastLength)))
            {
                dm = dm.replace("LAST", "L");
            } 
            if ((dayOfMonth.contains("LAST") && (dayOfMonth.length() != lastLength)))
            {
                dm = dm.replace("LAST", "L");
                dm = dm.replace("MINUS", "-");
            }
            if ((dayOfMonth.contains("LAST")) && dayOfMonth.contains("NEARESTWEEKDAY"))
            {
                dm = dm.replace("NEARESTWEEKDAY", "W");
                dm = dm.replace("LAST", "L");
            } 
            if ((!dayOfMonth.contains("LAST")) && dayOfMonth.contains("NEARESTWEEKDAY"))
            {
                dm = dm.replace("NEARESTWEEKDAY", "W");
            }

            //Crude input validation.
            for (int i = 0; i < dm.length(); i++)
            {
                if ((dm.charAt(i) == '/') || (dm.charAt(i) == '*') || (dm.charAt(i) == ',') || (dm.charAt(i) == '-') || (dm.charAt(i) == '?')
                || (dm.charAt(i) == 'L') || (dm.charAt(i) == 'W') || (dm.charAt(i) == '0') || (dm.charAt(i) == '1') || (dm.charAt(i) == '2') 
                || (dm.charAt(i) == '3') || (dm.charAt(i) == '4') || (dm.charAt(i) == '5') || (dm.charAt(i) == '6') || (dm.charAt(i) == '7') 
                || (dm.charAt(i) == '8') || (dm.charAt(i) == '9'))
                {
                    validChar = true;
	
                } else
                {
                    validChar = false;
                    break;
                }
            }
			
            if (validChar == false)
            {
	            dm = "invalid_input";
            }				
	

            this.dayOfMonth = dm + " ";
            return this;
        }

        /**
        * Setter method for months value of Cron.
        * @param String value that the user wishes to set for the Cron months field.
        * @return a CronConstructor instance with the value for the months field updated.
        */
        public CronConstructor monthsAre(String month)  
        {
            String mth = month;
            boolean validChar = true;

            //If 'UNTIL' is present, replace it with '-'.
            //If AND is present, replace it with ','.
            //If ALL is present, replace it with '*'.
            //If FROM EVERY is present, delete those words, 
            //then find the numbers and insert '/' between them.
            if (month.contains("UNTIL"))
            {
	            mth = mth.replace("UNTIL", "-");
            } else if ((month.contains("AND")))	
            {
	            mth = mth.replace("AND", ",");
            } else if ((month.contains("ALL")))
            {
	            mth = mth.replace("ALL", "*");
            } else if (month.contains("FROM"))
            {
	            mth = mth.replace("FROM", "");
	            mth = mth.replace("EVERY", "/");				
            }				
		    
            //Crude input validation.
            for (int i = 0; i < mth.length(); i++)
            {
                if ((mth.charAt(i) == '/') || (mth.charAt(i) == '*') || (mth.charAt(i) == ',') || (mth.charAt(i) == '-')
                || (mth.charAt(i) == 'J') || (mth.charAt(i) == 'F') || (mth.charAt(i) == 'M') || (mth.charAt(i) == 'A') 
                || (mth.charAt(i) == 'S') || (mth.charAt(i) == 'O') || (mth.charAt(i) == 'N') || (mth.charAt(i) == 'D')
                || (mth.charAt(i) == 'E') || (mth.charAt(i) == 'B') || (mth.charAt(i) == 'R') || (mth.charAt(i) == 'P')
                || (mth.charAt(i) == 'Y') || (mth.charAt(i) == 'U') || (mth.charAt(i) == 'L') || (mth.charAt(i) == 'G')
                || (mth.charAt(i) == 'T') || (mth.charAt(i) == 'C') || (mth.charAt(i) == 'V'))
                {
	                validChar = true;
	
                } else
                {
	                validChar = false;
	                break;
                }
            }

            if (validChar == false)
            {
	            mth = "invalid_input";
            }	

            this.month = mth + " ";
            return this;
        }

        /**
        * Setter method for day of week value of Cron.
        * @param String value that the user wishes to set for the Cron day of week field.
        * @return a CronConstructor instance with the value for the day of week field updated.
        */
        public CronConstructor daysOfWeekAre(String dayOfWeek)  
        {
            String dw = dayOfWeek;
            boolean validChar = true;

            //If 'UNTIL' is present, replace it with '-'.
            //If AND is present, replace it with ','.
            //If ALL is present, replace it with '*'.
            //If FROM EVERY is present, delete those words, 
            //then find the numbers and insert '/' between them.
            //If NONESPECIFIED is present, replace it with '?'.
            //If LAST, and only LAST, is present, replace with 'L'.
            //If LAST is not all, then remove LAST and append it
            //to the end of the string (e.g. LASTFRI to FRIL).
            //If FIRST, SECOND, etc are present, remove from front
            //of string and append appropriate string to end.
            if (dayOfWeek.contains("UNTIL"))
            {
                dw = dw.replace("UNTIL", "-");
            }
			if ((dayOfWeek.contains("AND")))
            {
                dw = dw.replace("AND", ",");
            } 
			if ((dayOfWeek.contains("ALL")))
            {
                dw = dw.replace("ALL", "*");
            } 
			if (dayOfWeek.contains("FROM"))
            {
                dw = dw.replace("FROM", "");
                dw = dw.replace("EVERY", "/");				
            } 
			if ((dayOfWeek.contains("NONESPECIFIED")))
            {
                dw = dw.replace("NONESPECIFIED", "?");
            } 
			if ((dayOfWeek.contains("LAST") && (dayOfWeek.length() == lastLength)))
            {
                dw = dw.replace("LAST", "L");
            } 
			if ((dayOfWeek.contains("LAST") && (dayOfWeek.length() != lastLength)))
            {
                dw = dw.replace("LAST", "");
                dw = dw.concat("L");
            } 
			if ((dayOfWeek.contains("FIRST")))
            {
                dw = dw.replace("FIRST", "");
                dw = dw.concat("#1");
            } 
			if ((dayOfWeek.contains("SECOND")))
            {
                dw = dw.replace("SECOND", "");
                dw = dw.concat("#2");
            } 
			if ((dayOfWeek.contains("THIRD")))
            {
                dw = dw.replace("THIRD", "");
                dw = dw.concat("#3");
            } 
			if ((dayOfWeek.contains("FOURTH")))
            {
                dw = dw.replace("FOURTH", "");
                dw = dw.concat("#4");
            } 
			if ((dayOfWeek.contains("FIFTH")))
            {
                dw = dw.replace("FIFTH", "");
                dw = dw.concat("#5");
            } 
			if ((dayOfWeek.contains("SIXTH")))
            {
                dw = dw.replace("SIXTH", "");
                dw = dw.concat("#6");
            } 
            if ((dayOfWeek.contains("SEVENTH")))
            {
                dw = dw.replace("SEVENTH", "");
                dw = dw.concat("#7");
            }

            //Crude input validation.
            for (int i = 0; i < dw.length(); i++)
            {
                if ((dw.charAt(i) == '/') || (dw.charAt(i) == '*') || (dw.charAt(i) == ',') || (dw.charAt(i) == '-') || (dw.charAt(i) == '?')
                || (dw.charAt(i) == 'L') || (dw.charAt(i) == '#') || (dw.charAt(i) == 'M') || (dw.charAt(i) == 'T') || (dw.charAt(i) == 'W') 
                || (dw.charAt(i) == 'F') || (dw.charAt(i) == 'S') || (dw.charAt(i) == 'O') || (dw.charAt(i) == 'N') || (dw.charAt(i) == 'U')
                || (dw.charAt(i) == 'E') || (dw.charAt(i) == 'D') || (dw.charAt(i) == 'H') || (dw.charAt(i) == 'R') || (dw.charAt(i) == 'I')
                || (dw.charAt(i) == 'A'))
                {
                    validChar = true;

                } else
                {
                    validChar = false;
                    break;
                }
            }

            if (validChar == false)
            {
                dw = "invalid_input";
            }		

            this.dayOfWeek = dw + " ";
            return this;
        }

        /**
        * Setter method for year value of Cron.
        * @param String value that the user wishes to set for the Cron year field.
        * @return a CronConstructor instance with the value for the year field updated.
        */
        public CronConstructor yearsAre(String year)  
        {
            String y = year;
            boolean validChar = true;
			
            //If 'UNTIL' is present, replace it with '-'.
            //If AND is present, replace it with ','.
            //If ALL is present, replace it with '*'.
            //If FROM EVERY is present, delete those words, 
            //then find the numbers and insert '/' between them.
            if (year.contains("UNTIL"))
            {
                y = y.replace("UNTIL", "-");
            }
			if ((year.contains("AND")))	
            {
                y = y.replace("AND", ",");
            } 
			if ((year.contains("ALL")))
            {
                y = y.replace("ALL", "*");
            } 
			if (year.contains("FROM"))
            {
                y = y.replace("FROM", "");
                y = y.replace("EVERY", "/");				
            } 				

            //Crude input validation.
            for (int i = 0; i < y.length(); i++)
            {
                if ((y.charAt(i) == '/') || (y.charAt(i) == '*') || (y.charAt(i) == ',') || (y.charAt(i) == '-')
                || (y.charAt(i) == '0') || (y.charAt(i) == '1') || (y.charAt(i) == '2') || (y.charAt(i) == '3') 
                || (y.charAt(i) == '4') || (y.charAt(i) == '5') || (y.charAt(i) == '6') || (y.charAt(i) == '7') 
                || (y.charAt(i) == '8') || (y.charAt(i) == '9'))
                {
                    validChar = true;

                } else
                {
                    validChar = false;
                    break;
                }
            }

            if (validChar == false)
            {
                y = "invalid_input";
            }

            this.year = y + " ";
            return this;
        }

        /**
        * Setter method for minutes value of Cron, in case the user wishes to leave the field empty.
        * @return a CronConstructor instance with the value for the year field set to empty.
        */
        public CronConstructor yearsAre()  
        {
            this.year = "";
            return this;
        }

        /**
        * This method returns a Cron instance with the class variables all set to the
        * values input as parameters to preceding CronConstructor setter methods, assuming
        * that the user has used those methods.
        * @return a Cron instance.
        */
        public Cron construct() 
        {
            return new Cron(this);
        }
    } 

    /**
    * toString method for debugging, and also presumably for interfacing with Quartz
    * scheduler. We are interested in the String value of the Cron object, as we are 
    * ultimately looking to provide the scheduler with a cron string.
    * @return a cron string.
    */
    public String toString() 
    {
        return this.seconds + this.minutes + this.hours + this.dayOfMonth
             + this.month + this.dayOfWeek + this.year;
    }

    /**
    * Main method for creating our new Cron/cron string.
    */
    public static void main (String[] args)
    {
        Cron c = new Cron.CronConstructor()
                         .secondsAre("3UNTIL45")
                         .daysOfWeekAre("LASTTHURS")
                         .monthsAre("ALL")
                         .minutesAre("30")
                         .hoursAre("FROM0EVERY3")
                         .daysOfMonthAre("LASTMINUS3")
                         .yearsAre()
                         .construct();

        System.out.println(c);
    }	
}
