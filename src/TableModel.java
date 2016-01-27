import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {
    private int columns = 4;
    public ArrayList<String []> dataArrayList;

    public TableModel(){
        dataArrayList = new ArrayList<String []>();
        for(int i = 0; i < dataArrayList.size(); i++){
            dataArrayList.add(new String[getColumnCount()]);
        }
    }
    @Override
    public int getColumnCount() {

        return columns;
    }

    @Override
    public int getRowCount() {

        return dataArrayList.size();
    }

    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "ФИО";
            case 1: return "Город";
            case 2: return "Станция метро";
            case 3: return "Адрес";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArrayList.get(rowIndex);
        return  rows[columnIndex];
    }

    public void addData(String[] row){
        dataArrayList.add(row);
    }


}
