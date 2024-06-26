package com.prioritytransportation;

import java.util.Comparator;
import java.util.PriorityQueue;

class Transportation 
{
    private int urgency;
    private double distance;
    private String description;

    public Transportation(int urgency, double distance, String description) 
    {
        this.urgency = urgency;
        this.distance = distance;
        this.description = description;
    }

    public int getUrgency() 
    {
        return urgency;
    }

    public double getDistance() 
    {
        return distance;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString() {
        return "Request{" +
                "urgency=" + urgency +
                ", distance=" + distance +
                ", description='" + description + '\'' +
                '}';
    }
}

class TransportationComparator implements Comparator<Transportation>
{

	@Override
	public int compare(Transportation o1, Transportation o2)
	{
		 int urgencyComparison = Integer.compare(o2.getUrgency(), o1.getUrgency());
	      
	        if (urgencyComparison != 0)
	        {
	            return urgencyComparison;
	        }
	        return Double.compare(o1.getDistance(), o2.getDistance());
		
	}

}

public class TransportationExample
{
    public static void main(String[] args) 
    {
        Comparator<Transportation> comparator = new TransportationComparator();
        PriorityQueue<Transportation> queue = new PriorityQueue<>(comparator);

        queue.add(new Transportation(5, 10.5, "Regular delivery"));
        queue.add(new Transportation(9, 2.0, "Urgent medical transport"));
        queue.add(new Transportation(3, 5.2, "Product delivery"));
        queue.add(new Transportation(7, 8.0, "VIP transport"));
        queue.add(new Transportation(7, 3.5, "Business delivery"));

        System.out.println("Processing transportation requests:");

        while (!queue.isEmpty())
        {
            Transportation trans = queue.poll();
            System.out.println(trans);
        }
    }
}
