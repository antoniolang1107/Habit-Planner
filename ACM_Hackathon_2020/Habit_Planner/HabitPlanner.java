/* Author: Tony Lang
 * Date: 11/15/20
 * 2020 Hackathon
 * Habit Planner
 */

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HabitPlanner
{
    private ArrayList<Habit> habitList = new ArrayList<Habit>();
    private File habitFile = new File("habits.txt");

    public HabitPlanner()
    {
        ReadFile();
    }

    public void ReadFile()
    {
        String tempHabit, tempUnit;
        int tempStart, tempIncrease, tempGoal;
        Habit tempHabitObj;
        try
        {
            Scanner readFile = new Scanner(habitFile);
            while (readFile.hasNext())
            {
                tempHabit = readFile.next();
                tempUnit = readFile.next();
                tempStart = readFile.nextInt();
                tempIncrease = readFile.nextInt();
                tempGoal = readFile.nextInt();

                addHabit(tempHabit, tempUnit, tempStart, tempIncrease, tempGoal);
            }
            readFile.close();
        } // ends try
        catch(FileNotFoundException e)
        {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        } // ends catch
    } // ends ReadFile
    public void writeFile()
    {
        try
        {
            FileWriter myWrite = new FileWriter(habitFile);
            for(int i = 0; i < habitList.size(); i++)
            {
                myWrite.write(habitList.get(i).output());
            }
            myWrite.close();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addHabit(String name, String unit, int start, int increase, int goal)
    {
        Habit tempHabit = new Habit(name, unit, start, increase, goal);   
        habitList.add(tempHabit);
    }

    public String textOutput()
    {
        String tempString = "";
        for(int i = 0; i < habitList.size(); i++)
        {
            tempString += habitList.get(i).output();
        }

        return tempString;
    }

    public void removeHabit(String habitName)
    {
        for(int i = 0; i < habitList.size(); i++)
        {
            if(habitName.equals(habitList.get(i).getHabit()))
            {
                habitList.remove(i);
            }
        }
    }
}
