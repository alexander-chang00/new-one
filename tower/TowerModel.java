package tower;

public class TowerModel {

    // 2d array storing game state
    private IntegerStack[] towers;

    // Final tower height
    private int towerHeight = 0;

    // Debug metrics
    private int printCounter = 0;
    private int moveCounter = 0;

    /* This class implements a model of a tower of Hanoi game.

        |    |    |
        =    |    |
       ===   |    |
      =====  |    |
     ------------------
        0    1    2

     Example of a game of height three in the starting position.

    */
    public TowerModel(int height)
    {
        towerHeight = height;
        towers = new IntegerStack[3];
        towers[0] = new IntegerStack(height);
        towers[1] = new IntegerStack(height);
        towers[2] = new IntegerStack(height);

        for (int i=0; i<height; i++)
        {
            towers[0].push(height - i);
        }
    }

    // get the total number of disks
    public int height()
    {
        return towerHeight;
    }


    // Move one disk from the source stack to the destination stack.
    // No disk number provided.
    public void move(int source, int destination)
    {
        System.out.println("Move #" + ++moveCounter + " from tower" + source + " to tower" + destination);
        if (towers[source].isEmpty())
        {
            System.out.println("Illegal move: source tower is empty");
            return;
        }
        if (!towers[destination].isEmpty() && towers[source].peek() > towers[destination].peek())
        {
            System.out.println("Illegal move: cannot place larger disk on top of smaller disk");
            return;
        }
        towers[destination].push(towers[source].pop());
    }

    //overloaded
    public void move(int disk, int source, int destination)
    {      
        System.out.println("Move #" + ++moveCounter + ": disk" + disk + " from tower" + source + " to tower" + destination);
        if (towers[source].peek() != disk)
        {
            System.out.println("Illegal move: disk" + disk + " is not on top of source tower");
            return;
        }
        if (towers[source].isEmpty())
        {
            System.out.println("Illegal move: source tower is empty");
            return;
        }
        if (!towers[destination].isEmpty() && towers[source].peek() > towers[destination].peek())
        {
            System.out.println("Illegal move: cannot place larger disk on top of smaller disk");
            return;
        }
        towers[destination].push(towers[source].pop());
    }

    // Helper method to nicely print the current model state.
    public void print()
    {
        System.out.print("Print #" + ++printCounter + " Towers of Hanoi\n");

        for (int layer = towerHeight-1; layer >= 0; layer--){
            System.out.print("\n");
            for (int tower = 0; tower < towers.length; tower++) {
                int value = towers[tower].get(layer);
                if (value == 0)
                {
                    System.out.print(" |");
                } else
                {
                    System.out.print(" " + value);
                }
            }
        }
        System.out.println();
        for (int i = 0; i < towers.length; i++) {
            System.out.print(" =");
        }
        System.out.println();
    }

    // Test instrumentation
    public IntegerStack[] getTowers()
    {
        return towers;
    }

    public int getHeight()
    {
        return towerHeight;
    }
}
