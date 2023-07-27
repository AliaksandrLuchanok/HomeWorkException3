package HomeWorkException3;

public class CreateHuman extends Human {

    private String[] useDataCells;
    public CreateHuman(String [] useDataCells) {
        super(useDataCells[0],
                useDataCells[1],
                useDataCells[2],
                useDataCells[3],
                useDataCells[4],
                useDataCells[5]);
    }
    public void setUseValidHuman(String [] useDataCells) {
        this.useDataCells = useDataCells;
    }
}
