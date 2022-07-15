public class MainApp{
    public static void main(String[] args){

        String[][] mmsv = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","1O","11","12"},
                {"13","14","15","16"}
        };

        try {
            int summ = getDataMsv(mmsv);
            System.out.println("Расчет Ок! \nСумма: "+summ);
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println("Расчет не был выполнен!\n"+e.getMessage());
        }
    }

    public static int getDataMsv(String[][] mmsv){
        if (mmsv!=null && (mmsv.length==4)){
            for (int i = 0; i < mmsv.length;i++)
                if (mmsv[i]==null || mmsv[i].length!=4) throw new MyArraySizeException("Вложенный одномерный массив index["+i+"] пуст, либо количество элементов в нем не равно 4.");
        } else throw new MyArraySizeException("Двумерный массив пуст, либо количество вложенных одномерных массивов не равно 4.");

        int summ=0;

        for (int i = 0; i<mmsv.length;i++) {
            for (int j=0; j < mmsv[i].length ;j++) {
                try {
                    summ += Integer.parseInt(mmsv[i][j]);
                } catch (NumberFormatException e){
                    summ=0;
                    throw new MyArrayDataException("Некорректные данные в массиве index["+i+"]["+j+"]. Требуется число, а содержится:["+mmsv[i][j]+"].");
                }
            }
        }
        return summ;
    }
}
