package org.uob.a1;

public class Inventory {
    final int MAX_ITEMS = 10;
    private String[] items;
    private int itemCount;

    public Inventory()
    {
        items = new String[MAX_ITEMS];
        itemCount = 0;
    }

    public void addItem(String item)
    {
        if ( itemCount < MAX_ITEMS)
        {
            items[itemCount] = item;
            itemCount = itemCount + 1;
        }
        else
        {
            System.out.println("Sorry! Your Inventory Is Full");
        }
        //Adds an item to the array if there is space
    }

    public int hasItem(String item)
    {
        for( int i = 0; i < itemCount; i++)
        {
            if( items[i] == item)
            {
                return i;
            }
        }
        return -1;
        //Returns the position of the item in the array if it is in the array. Otherwise it returns -1
    }

    public void removeItem(String item)
    {
        int itemPosition = hasItem(item);
        if ( itemPosition != -1)
        {
            for(int i = itemPosition; i < itemCount - 1; i++)
            {
                items[i] = items[i + 1];
            }
            items[itemCount - 1] = null;
            itemCount = itemCount - 1;
                    
        }
    }
        
            
        //Removes a specified item while ensuring there are no empty elements in the array.
    

    public String displayInventory()
    {
        String invDisplay = "";
        for (int i = 0; i < itemCount; i++)
        {
            invDisplay += items[i] + " ";
        }
        return invDisplay;
        
        // Returns a String of all items separated by spaces (note that there is a space after the last item as well).
    }
}
