package sample;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class Field {        //по факту получилось так, что класс филд = класс плеер

    private int xSize;
    private int ySize;
    String name;        // имя игрока

    public String[][] firstField;         // поле с кораблями
    public String[][] accessoryField; // поле по которому стреляем

    //    int[][] secondField;
    //    int[][] accessoryFieldTwo;

            //ЭТО НАДО БУДЕТ ЕЩЕ ПРИ РАССТАНОВКЕ КОРАБЛЕЙ ПРОВЕРЯТЬ ВЛЕЗЕТ ЛИ ХОТЯ БЫ В ОДНОМ НАПРАВЛЕНИИ КОРАБЛЬ ТАКОГО РАЗМЕРА
            // еще надо переделать под стринг поля, потому что так красивее, будут "*", "К" и "П" промахи"+
            //нужно как-то сообщать: только ранил корабль, либо убил

    private ArrayList<Ship> shipArrayList = new ArrayList<>();       // список лодок

    Field(int xSize, int ySize, String name){
        this.xSize=xSize;
        this.ySize=ySize;
        this.name=name;
    }       // конструктор

    void createFields(){         //создаем два поля
        firstField= new String[xSize][ySize];
       // secondField= new int[field.xSize][field.ySize];
        accessoryField= new String[xSize][ySize];
      //  accessoryFieldTwo= new int[field.xSize][field.ySize];


        for (int i=0; i<xSize; i++){
            for (int j=0; j<ySize; j++){
                firstField[i][j]="*";
             //   secondField[i][j]=0;
                accessoryField[i][j]="*";
              //  accessoryFieldTwo[i][j]=0;
            }
        }

       printFields();
    } //создаем два поля

    private void nullifyFirstField(){                // заполнить первое поле нулями
        for (int i=0; i<firstField.length; i++){
            for (int j=0; j<firstField[i].length; j++){
                firstField[i][j]="*";
            }
        }
    }  // заполнить первое поле нулями


    private void printFields(){      //вывести оба поля
        System.out.println();
        System.out.println("ОСНОВНОЕ ПОЛЕ " + name);
        for (int i=0; i<firstField.length; i++){
            for (int j=0; j<firstField[i].length; j++){
                System.out.print(firstField[i][j] + "\t");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println("ДОПОЛНИТЕЛЬНОЕ ПОЛЕ " + name);
        for (int i=0; i<accessoryField.length; i++){
            for (int j=0; j<accessoryField[i].length; j++){
                System.out.print(accessoryField[i][j] + "\t");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }  //вывести оба поля

    private void fillFieldWithShips(){  // выставляаем корабли на поле, после каждого добавленного корабля поле обновляется
        nullifyFirstField();
        shipArrayList.forEach(ship -> {
            int temp;
            firstField[ship.getxPos()][ship.getyPos()]="К";
            if (ship.length>1){
                temp=ship.length-1;
            } else
                temp=1;
            for (int i=0; i<=temp; i++) {
            switch(ship.direction){
                    case UP:
                        firstField[ship.getxPos() - i][ship.getyPos()] = "К";
                        break;
                    case DOWN:
                        firstField[ship.getxPos() + i][ship.getyPos()] = "К";
                        break;
                    case LEFT:
                        firstField[ship.getxPos()][ship.getyPos() - i] = "К";
                        break;
                    case RIGHT:
                        firstField[ship.getxPos()][ship.getyPos() + i] = "К";
                        break;
                }
            }
        });
    }           // выставляаем корабли на поле, после каждого добавленного корабля поле обновляется

    private void addShip(Ship ship){         //добавить корабль в массив, не знаю зачем, но пускай будет отдельно, может пригодится
        shipArrayList.add(ship);
        fillFieldWithShips();                   //вроде пригодилось
    } //добавить корабль в массив

    //раскомментить   //раскомментить   //раскомментить   //раскомментить   //раскомментить
    void createShips(){
        /// ТУТ ИЗМЕНЯЕТСЯ КОЛИЧЕСТВО КОРАБЛЕЙ


        //создаем корабли, надо бы добавить проверку на выход Х и У за границы массива, но мне лень
        // потом, все равно, под рандом переделывать, там сделаю проверку
        //  рандом == все эти систем ины заменить входными параметрами х у дирекшн, а в методе, который будет это все вызывать
        // там уже смотреть на границы, куницы и все остальное

        // если это все ещё тут, значит что-то не получилось :)  //ну либо получилось но            //


        int count1=0;
        int count2=0;
        int count3=0;
        int count4=0;

        System.out.println(name + " РАССТАВЛЯЕТ КОРАБЛИ");
        System.out.println("всего 4х1 2х3 3х2 1х4");

        System.out.println("СЦЕНА ПОЯВИТСЯ ПОСЛЕ ВВОДА ПОЗИЦИЙ КОРАБЛЕЙ, ЕСЛИ ЭТО ВСЕ ЕЩЕ НАПИСАНО, ЗНАЧИТ Я НЕ СТАЛ ЭТО ФИКСИТЬ");
        while (count1<4) {   // ////// В WHILE МЕНЯЕТСЯ КОЛИЧЕСТВО КОРАБЛЕЙ

            // это дебильно, но мне так нравится       ////////////раскомментить
          shipSetter(count1,1, "одноразового");
          count1++;
        }
//
//            //раскомментить
        while (count2<3){
            shipSetter(count2,2, "двухмачтового");
            count2++;
//            System.out.println("Введите х "+(count2+1) + "-го двухмачтового корабля");
//            int x=scan.nextInt();
//            System.out.println("Введите y "+(count2+1) + "-го двухмачтового корабля");
//            int y=scan.nextInt();
//            int length=2;
//            System.out.println("Введите направление этого корабля: ");
//            String dir = scan.nextLine();
           // Direction direction=switchDirection(length);
          //  addShip(new Ship(x,y,length,direction));
        }
        while (count3<2) {
            shipSetter(count3,3, "трёхпалубного");
            count3++;
        }
        while (count4<1) {
            shipSetter(count4,4, "четырёхдверного");
            count4++;
        }
        //раскомментить
        System.out.println("Корабли созданы, список: ");
        printShipList();
        System.out.println();
        System.out.println();
        printFields();

    }       //   создаем все корабли поочередно, вызывает шип сеттер
    //раскомментить   //раскомментить   //раскомментить   //раскомментить   //раскомментить
    private void shipSetter(int count, int length, String type){                     //расставляем ОДИН корабль, введите то, введите это (вызывает свич дирекшн)
        Position positionTemp=checkPosition(count,type);
        int x=positionTemp.getX();
        int y=positionTemp.getY();
        Direction direction = switchDirection(x, y, length);
        ArrayList<Position> blocksListTemp = addShipPositionsToArray(x,y,length,direction);

        addShip(new Ship(x,y,length,direction, true, blocksListTemp));
    }  //расставляем ОДИН корабль, введите то, введите это (вызывает свич дирекшн)

    private ArrayList<Position> addShipPositionsToArray(int x, int y, int length, Direction direction){ //добавляем все ячейки корабля в массив
        ArrayList<Position> blocksListTemp = new ArrayList<>();
        int temp;
        blocksListTemp.add(new Position(x,y));
        if (length>1){
            temp=length-1;
        } else
            temp=1;
        for (int i=0; i<=temp; i++) {
            switch(direction){
                case UP:
                    blocksListTemp.add(new Position(x-i,y));
                    break;
                case DOWN:
                    blocksListTemp.add(new Position(x+i,y));
                    break;
                case LEFT:
                    blocksListTemp.add(new Position(x,y-i));
                    break;
                case RIGHT:
                    blocksListTemp.add(new Position(x,y+i));
                    break;
            }
        }

        return blocksListTemp;
    }       //добавляем все ячейки корабля в массив

    private Position checkPosition(int count, String type){      // ой намудрил я с этими методами
        boolean isAvailable=false;
        Scanner scan = new Scanner(System.in);
        int x=0,y=0;
        avblNew: while (!isAvailable){
            System.out.println("Введите х "+(count+1) + "-го "+type+" корабля");
            x = scan.nextInt();
            if (x >= firstField.length || x < 0) {
                System.out.println("Так корабль поставить нельзя введите новые значения");
                continue avblNew;
            }

            System.out.println("Введите y "+(count+1) + "-го "+type+" корабля");
            y=scan.nextInt();
            if (y<0 || y >= firstField[0].length){
                System.out.println("Так корабль поставить нельзя введите новые значения");
                continue avblNew;
            }
            ////////////////////////////////////сюда добавить проверку, имеется ли хоть одно положение(ап,даун,лефт,райт) при текущем х и у
            for (int i=(x-1); i<=(x+1); i++){
                for (int j=(y-1); j<=(y+1); j++){
                    if (i>=0 && i<firstField.length && j>=0 && j<firstField[0].length) {
                        if (firstField[i][j].equals("К")) {
                            System.out.println("Так корабль поставить нельзя введите новые значения");
                            continue avblNew;
                        }
                    }
                }
            }
            isAvailable=true;
        }

        return new Position(x,y);
    }           // проверка доступности х и у, добавить потом кое-что(внутри написано)

    private Direction switchDirection(int x, int y, int length){       //ну это понятно, понятно что по-идиотски, но понятно,                       в конце концов, это моя программа и я делаю ее так, как захочу
       boolean isAvailable = false;
        Direction direction=Direction.NONE;
        Scanner scan = new Scanner(System.in);
        if (length>1) {

            avbl: while (!isAvailable) {
                System.out.println("Введите направление хвоста корабля в формате: UP/DOWN/LEFT/RIGHT");
                String dir = scan.nextLine();
                switch (dir) {
                    case "UP":      // да, это можно было бы расписать отдельным методом, но мне лень
                        for (int i=(x-(length-1)-1); i<=(x+1); i++){  //-1-1 написано для того, чтобы было понятно, -1 это голова корабля -1 это бонусная ячейка, обязательный промежуток между кораблями
                             for (int j=(y-1); j<=(y+1); j++){
                                 if (i>=0 && i<firstField.length && j>=0 && j<firstField[0].length) {
                                     if (firstField[i][j].equals("К") || x - (length - 1) < 0) {
                                         System.out.println("Так корабль поставить нельзя введите новое значение");
                                         continue avbl;
                                     }
                                 }
                             }
                        }
                        direction = Direction.UP;
                        isAvailable=true;
                        break;
                    case "DOWN":
                        for (int i=(x-1); i<=(x+(length-1)+1); i++){
                            for (int j=(y-1); j<=(y+1); j++){
                                if (i>=0 && i<firstField.length && j>=0 && j<firstField[0].length) {
                                    if (firstField[i][j].equals("К") || x + (length - 1) >= firstField.length) {
                                        System.out.println("Так корабль поставить нельзя введите новое значение");
                                        continue avbl;
                                    }
                                }
                            }
                        }
                        direction = Direction.DOWN;
                        isAvailable=true;
                        break;
                    case "LEFT":
                        for (int i=(x-1); i<=(x+1); i++){
                            for (int j=(y-(length-1)-1); j<=(y+1); j++){
                                if (i>=0 && i<firstField.length && j>=0 && j<firstField[0].length) {
                                    if (firstField[i][j].equals("К") || (y - (length - 1)) < 0) {   // да. да. ну и что
                                        System.out.println("Так корабль поставить нельзя введите новое значение");
                                        continue avbl;
                                    }
                                }
                            }
                        }
                        direction = Direction.LEFT;
                        isAvailable=true;
                        break;
                    case "RIGHT":
                        for (int i=(x-1); i<=(x+1); i++){
                            for (int j=(y-1); j<=(y+(length-1)+1); j++){
                                if (i>=0 && i<firstField.length && j>=0 && j<firstField[0].length) {
                                    if (firstField[i][j].equals("К") || y + (length - 1) >= firstField[0].length) {
                                        System.out.println("Так корабль поставить нельзя введите новое значение");
                                        continue avbl;
                                    }
                                }
                            }
                        }
                        direction = Direction.RIGHT;
                        isAvailable=true;
                        break;
                    default:
                        direction = Direction.NONE;

                }
            }

        }  else
            direction=Direction.NONE;       //лишнее
        return direction;
    }       //указываем направление и проверяем войдет ли туда целый корабль

    private void printShipList(){            //вывести список кораблей
        shipArrayList.forEach(ship -> {
            System.out.println("x: " + ship.xPos + " || y: " + ship.yPos + " || length: " + ship.length + " || dir: " + ship.direction);
        });
    }       //вывести список кораблей
            /// осталось сделать стрельбу и проверку, описанную выше
            //      для стрельбы нужно как то понимать жив корабль или нет, может создать массив с ячейками или оййойойой как же костыльно все это будет


    boolean shooting(Field shooter, Field target){           //выстрелы, много выстрелов, хотя вообще один но может быть и больше, если попал, но это типа родительский метод
        System.out.println("СТРЕЛЯЕТ ИГРОК: " + name);

        Scanner scan = new Scanner(System.in);
        boolean canShoot = true;
        while (canShoot){
            System.out.println("Введите X для выстрела: " );
            int x = scan.nextInt();
            System.out.println("Введите Y для выстрела: " );
            int y = scan.nextInt();
                //сделать проверку на доступность выстрела
                canShoot=shot(x,y,shooter, target);
                printFields();
            boolean temp1=aliveCheck(target);
            boolean temp2=aliveCheck(shooter);
            System.out.println("temp1: " + temp1 + " temp2: " + temp2);
            if (temp1 && temp2){

                System.out.println("корабли еще есть");
            } else {
                System.out.println("кораблей больше нет");
            return false;}
        }
        System.out.println("Игрок " + name + " отстрелялся");

        return true;
    } //выстрелы, много выстрелов, хотя вообще один но может быть и больше, если попал, но это типа родительский метод


    private boolean shot(int x, int y, Field shooter, Field target){     //один выстрел
        boolean isOffended=false;
        if (target.firstField[x][y].equals("К")){
            isOffended=true;
            System.out.println("Попадание! " + x + " " + y);
                target.shipArrayList.forEach(ship -> {

                for (int i=0; i<ship.shipBlocksArrayList.size(); i++){
                    if (ship.shipBlocksArrayList.get(i).getX()==x && ship.shipBlocksArrayList.get(i).getY()==y){
                        System.out.println("@@@@@");
                        ship.shipBlocksArrayList.remove(i);
                        i--;

                        if (!ship.shipBlocksArrayList.isEmpty()){
                            System.out.println("Подбил, корабль еще на плаву");
                        } else {
                            ship.isAlive=false;
                            System.out.println("Корабль уничтожен");
                        }

                    }
                }

//
//                    ship.shipBlocksArrayList.forEach(position -> {
//                        count.getAndIncrement();
//                        if (position.getX()==x && position.getY()==y) {
//                            System.out.println("@@@@@@@");
//                            temp.set(count);
//                        }
//                        });
//                        ship.shipBlocksArrayList.remove(temp.get());


//                    System.out.println("for each ship -> ");
//                    if (ship.shipBlocksArrayList.contains(new Position(x,y))){
//
//                        System.out.println("контейнс ки");
//                        ship.shipBlocksArrayList.remove((new Position(x,y)));
//                        if (!ship.shipBlocksArrayList.isEmpty()){
//                            System.out.println("Подбил, корабль еще на плаву");
//                        } else {
//                            ship.isAlive=false;
//                            System.out.println("Корабль уничтожен");
//                        }
//                    } else {
//                        System.out.println("else");
//                    }

                    ship.shipBlocksArrayList.forEach(k->{
                        System.out.println("x " + k.getX() + " y " + k.getY());
                    });

                });

                shooter.accessoryField[x][y]="+";
                target.firstField[x][y]="+";
        } else if (target.firstField[x][y].equals("+") || target.firstField[x][y].equals("-") || x<0 /* я не понимаю почему это условие всегда фолс */ || x>=firstField.length || y<0 || y>=firstField[0].length){
            System.out.println("Сюда нельзя стрелять, стреляйте еще раз");
            return isOffended;
        } else {
            shooter.accessoryField[x][y]="-";
            target.firstField[x][y]="-";
            System.out.println("Нет попадания");
        }
return isOffended;
    }  //один выстрел


    private boolean aliveCheck(Field player){        //проверка на наличие живых кораблей в команде


        for (int i=0; i<player.shipArrayList.size(); i++){
            if (!player.shipArrayList.get(i).isAlive){
                System.out.println("нашло удалило new");
                player.shipArrayList.remove(i);
                i--;
            }
        }

//        player.shipArrayList.forEach(ship -> {
//            if (!ship.isAlive){
//                System.out.println("нашло удалило");
//                player.shipArrayList.remove(ship);
//            }
//        });

        System.out.println("размер массива с лодками " + player.shipArrayList.size());
        return !player.shipArrayList.isEmpty();     //тру если есть лодки, фолс если нет, ну это и так понятно
    }  //проверка на наличие живых кораблей в команде



    ////////////////////добавить выделение вокруг уничтоженного корабля
}

