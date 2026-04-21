package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        // Call the missing solve method (not this one)
        int towerHeight = this.model.height();
        solve(towerHeight, 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    //
    private void solve(int n, int from_rod, int to_rod, int aux_rod)
    {
        if (n == 0) {
            return;
        }

        solve(n - 1, from_rod, aux_rod, to_rod);
        model.move(n, from_rod, to_rod);
     
        solve(n - 1, aux_rod, to_rod, from_rod);
    }
 

}
