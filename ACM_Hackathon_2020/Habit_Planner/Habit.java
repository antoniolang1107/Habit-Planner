/* Author: Tony Lang
 * Date: 11/15/20
 * Habit class
 */

public class Habit
{
    private String myHabit;
    private String myUnit;
    private int myStart;
    private int myIncrease;
    private int myGoal;
    private int myCurrent;
    
    public Habit(String habit, String unit, int start, int increase, int goal)
    {
        myHabit = habit;
        myUnit = unit;
        myStart = start;
        myIncrease = increase;
        myGoal = goal;
    }
    
    public String getHabit()
    {
        return myHabit;
    }
    public String getUnit()
    {
        return myUnit;
    }
    public int getStart()
    {
        return myStart;
    }
    public int getIncrease()
    {
        return myIncrease;
    }
    public int getGoal()
    {
        return myGoal;
    }
    public int getCurrent()
    {
        return myCurrent;
    }
    public String output()
    {
        return myHabit+"\t"+myUnit+"\t"+myStart+"\t"+myIncrease+"\t"+myGoal+"\n";
    }
}
