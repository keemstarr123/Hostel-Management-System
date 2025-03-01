/*
Object-Oriented Programming CSEB3313 Group Project 
Group Name: Chill Guys (Group 20)

Group member:
1.Jeevesh A/L Perapakaran SW01083692 (Leader)
2.Iqmal Hakim Bin Zaidi CS01083691
3.Muhammad Akeef bin Ahmad SW01083700
4.Thong Hao Hong SW01083725
5.Muhammad Anas bin Shamsul SW0106060

Topic: Hostel Management System 
*/

//Import package for scanner and ArrayList
import java.util.*;

//Base Class
class Room {
    //Define attributes that can be used by all room
    protected int roomNumber;
    protected int capacity;
    protected int occupancy;
    protected Resident[] occupants;
    
    //Define Get room number method
    public int getRoomNumber() {
        return this.roomNumber;
    }
    //Declare Get Capacity method
    public int getCapacity() {return this.capacity;}
    
    //Declare Get Occupancy method
    public int getOccupancy() {return this.capacity;}
    
    //Declare Get Occupants method
    public Resident[] getOccupants() {return this.occupants;}
    
    //Define Set room Number method
    public void setRoomNumber(int rn) {
        this.roomNumber = rn;
    }
    
    //Define Set Occupancy method
    public void setOccupancy() {
        this.occupancy++;
    }
    
    //Define Set Occupant method
    public void addOccupant(Resident resident) {}
}

//Subclass 'SingleRoom' extending from 'Room'
class SingleRoom extends Room {
    //Define attributes specifically for Single Room
    private static final int capacity = 1;
    private static int totalSingleRoom = 0;
    private Resident[] occupants;
    
    //Define Constructor for Single Room
    public SingleRoom() {
        setRoomNumber(totalSingleRoom);
        totalSingleRoom ++;
        this.occupancy = 0; 
        occupants = new Resident[1];
    }
    
    //Define SingleRoom Get Capacity method
    public int getCapacity() {
        return capacity;
    }
    
    //Define SingleRoom Get totalRoom method
    public static int getTotalSingleRoom() {
        return totalSingleRoom;
    }
    
    //Define SingleRoom Get Occupancy method
    public int getOccupancy() {
        return this.occupancy;
    }
    
    //Define SingleRoom Get Occupants method
    public Resident[] getOccupants() {
        return occupants;
    }
    
    //Define SingleRoom Set Occupants method
    public void addOccupant(Resident student) {
        if (this.getOccupancy() < this.getCapacity()) {
            setOccupancy();
            occupants[0] = student;
        } else {
            System.out.printf("The room %s is fully occupied with %d student(s).", this.getRoomNumber(), this.occupancy);        }
    }
    
    //Define SingleRoom Set Occupancy method
    public void setOccupancy() {
        this.occupancy++;
    }
    

}

//Subclass 'SharedRoom' extending from 'Room'
class SharedRoom extends Room {
    //Define attributes specifically for Shared Room
    private static final int capacity = 2;
    private static int totalSharedRoom = 0;
    private Resident[] occupants;
    
    //Define Constructor for Shared Room
    public SharedRoom() {
        setRoomNumber(totalSharedRoom+10);
        totalSharedRoom ++;
        this.occupancy = 0; 
        occupants = new Resident[2];
    }
    
    //Define SharedRoom Get Capacity method
    public int getCapacity() {
        return capacity;
    }
    
    //Define SharedRoom Get Occupancy method
    public int getOccupancy() {
        return this.occupancy;
    }
    
    //Define SharedRoom Get Occupants method
    public Resident[] getOccupants() {
        return occupants;
    }
    
    //Define SharedRoom Get TotalRoom method
    public static int getTotalSharedRoom() {
        return totalSharedRoom;
    }
    
    //Define SharedRoom Set Occupants method
    public void addOccupant(Resident student) {
        if (this.getOccupancy() < this.getCapacity()) {
            occupants[this.getOccupancy()] = student;
            setOccupancy();
        } else {
            System.out.printf("The room %s is fully occupied with %d student(s).", this.getRoomNumber(), this.occupancy);
        }
    }
    
    //Define SharedRoom Set Occupancy method
    public void setOccupancy() {
        this.occupancy++;
    }

}

// Another Base Class
class Resident {
    //Declare attributes of a resident
    private String name;
    private String studentID;
    private int roomNumber;
    private static int totalResident;
    
    //Define Constructor to initialize the attributes
    public Resident(String name, String studentID, int roomNumber) {
        this.name = name;
        this.studentID = studentID;
        this.roomNumber = roomNumber;
        totalResident++;
    }
    
    //Define Get Room Number Method
    public int getRoomNumber() {
        return this.roomNumber;
    }
    
    //Define Get Name Method
    public String getName() {
        return this.name;
    }
    
    //Define Get Student ID Method
    public String getStudentID() {
        return this.studentID;
    }
    
    //Define Get totalResident Method 
    public static int getTotalResident() {
        return totalResident;
    }
    
    //Define Set Student's RoomNumber Method
    public void setStudentRoomNumber(int rn) {
        this.roomNumber = rn;
    }
    
    //Define Set Name Method
    public void setName(String n) {
        this.name = n;
    } 
    
    //Define Set Student ID Method
    public void setStudentID(String ID) {
        this.studentID = ID;
    }
    
}

//Main Class
public class HostelManagementSystem  {
    //Initialize static class array variable to store rooms and residents
    static Room[] rooms = new Room[20];
    static Resident[] residents = new Resident[30];
    
    public static void main (String[] args) {
        //Create Single room objects for first 10 elements, and shared room for the last 10 objects 
        for (int i = 0; i<20;i++) {
            if (i < 10) {
                rooms[i] = new SingleRoom();
            } else {
                rooms[i] = new SharedRoom();
            }
        }
        
        //Define pseudo data for name, studentID and roomNumber
        String[] sample_name = {
            "Aiman Hakim bin Abdullah",
            "Nurul Izzah binti Ismail",
            "Lee Wei Sheng",
            "Tan Mei Ling",
            "Ramesh a/l Subramaniam",
            "Siti Aisyah binti Rahman",
            "Muhammad Haziq bin Azlan",
            "Chong Kai Lun",
            "Kavitha a/p Rajendran",
            "Nur Hana binti Zulkifli",
            "Ahmad Faiz bin Kamal",
            "Lim Jia Hui",
            "Devendran a/l Maniam",
            "Farah Nabila binti Mohd Yazid",
            "Wong Sze Min",
        };;
        String[] sample_studentID = {
            "SW20230001",
            "CS20230002",
            "SN20230003",
            "SW20230004",
            "CS20230005",
            "SN20230006",
            "SW20230007",
            "CS20230008",
            "SN20230009",
            "SW20230010",
            "CS20230011",
            "SN20230012",
            "SW20230013",
            "CS20230014",
            "SN20230015"
        };
        int[] sample_room = {1,5,10,11,11,14,14,2,7,10,18,18,15,17,17};
        
        //Create scanner object for reading user input
        Scanner scanner = new Scanner(System.in);
        
        //Initialize option chosen by user
        int choose = 0;
        
        
        //Insert the pseudo data into the array of objects
        for (int i = 0; i < 15; i++) {
            residents[i] = new Resident(sample_name[i], sample_studentID[i], sample_room[i]);
            allocateRoom(residents[i], sample_room[i]);
        }

        

        //Iteration statement (do-while)
        do {
            //Print Menu options and handle user input
            System.out.println("\n----------------------------------------------- \n" +
                               "  Welcome to Uniten Hostel Management System! \n" +
                               "----------------------------------------------- \n");
                            
            System.out.println("Please choose any of the options below: \n" +
                               "1. Room Allocation \n" + 
                               "2. View Rooms \n" +
                               "3. Search Students \n" +
                               "4. Generate Latest Report \n" +
                               "5. Exit \n" );

            System.out.print("Enter your option: ");
            choose = scanner.nextInt();
            
            //Handle invalid input
            if (choose < 1 || choose > 5 ) {
                System.out.println("\nInvalid option....Please try again");
            }

            else {

                //Selection statement (switch...case)
                switch (choose) {
                    case 1:
                        System.out.println("\n------------------- \n" +
                                           "  Room Allocation \n" + 
                                           "------------------- \n");

                        System.out.print("Enter student name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();

                        System.out.print("Enter student ID: ");
                        String stdID = scanner.nextLine();
                        
                        //Display empty room allowing user to make decision on which room to choose
                        showEmptyRoom();
                    
                        int num; 
                        do {
                            System.out.print("Enter room number to allocate: ");
                            num = scanner.nextInt();
                            if (num < 0 || num > 19) {
                                System.out.println("Invalid room number entered. Please try again.");
                            }
                        } while (num < 0 || num > 19);

                        //Create new Resident object 
                        Resident std = new Resident(name, stdID, num);

                        //Allocate room to the student
                        allocateRoom(std, num);
                        System.out.println("Room allocated successfully.");
                        break;

                    case 2:
                        System.out.println("\n-------------- \n" +
                                           "  View Rooms \n" + 
                                           "-------------- \n");
                        
                        //Display all room regardless of their availability    
                        viewRoom();
                        
                        break;

                    case 3:
                        System.out.println("\n------------------- \n" +
                                           "  Search Students \n" + 
                                           "------------------- \n");

                        //Iteration statement
                        do {
                            System.out.println("\nPlease choose any of the options below: \n\n" +
                                               "1. Search by name \n" +
                                               "2. Search by room number \n" +
                                               "3. Return \n");

                            System.out.print("Enter your option: ");
                            choose = scanner.nextInt();
                            
                            if (choose < 1 || choose > 3 ) {
                                System.out.println("\nInvalid option....Please try again");
                            }
                            else if (choose == 1 || choose == 2) {
                                //Search student by name / room number
                                searchStudent(choose);
                            }
                            
                        } while (choose != 3); //END-WHILE

                        break;
                    
                    case 4:
                        System.out.println("\n------------------------- \n" +
                                           "  Room Occupancy Report \n" +
                                           "------------------------- \n");
                        //Display Occupancy report, including rate of occupied room, partially occupied room and empty room
                        generateOccupancyReport();
                        break;

                    case 5:
                        //Display end message
                        System.out.println("\nExiting the program.... \n");
                        System.out.println("\nThank you for using Uniten Hostel Management System. \n");
                        break;
                
                    default:
                        break;
                }
            } 
        } while (choose != 5); //END-WHILE

        scanner.close();
    }
    
    //Static method for showing empty room before allocating empty room
    public static void showEmptyRoom() {
        System.out.println("\nEmpty Room: \n");
        String type;
        //Iterate all rooms in the static array of room
        for(Room room : rooms){
            if(room.getOccupancy() < room.getCapacity()){
                type = (room.roomNumber < 10) ? "Single Room" : "Shared Room";
                System.out.printf("Room %d (%s) | ", room.roomNumber, type);
            }
        }
        System.out.println("\n");
    }
    
    //Static method for allocating rooms to students
    public static void allocateRoom(Resident student,int roomNo){
        residents[Resident.getTotalResident()] = student;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNo) {
                //Set student room number and add student into the specific room
                student.setStudentRoomNumber(roomNo);
                room.addOccupant(student);
            }
        }
    }
    
    //Static method for viewing available and occupied rooms
    public static void viewRoom( ){
        //Sort available and occupied room first
        //Purpose of using arraylist is because it is a dynamic array, size may vary
        ArrayList<Room> available = new ArrayList<Room>();
        ArrayList<Room> occupied = new ArrayList<Room>();
        for(Room room : rooms){
            if(room.getOccupancy() >= room.getCapacity()){
                occupied.add(room);
            } else {
                available.add(room);
            }
        }
        
        //Display available room
        System.out.println("Available room:");
        int counter = 1;
        for (Room room: available) {
            System.out.printf("%d. Room ID: %d, remaining space: %d.\n", counter, room.getRoomNumber(), (room.getCapacity() - room.getOccupancy()));
            counter ++;
        }
        
        //Display occupied room
        System.out.println("\n\nOccupied room:");
        counter = 1;
        for (Room room: occupied) {
            System.out.printf("%d. Room ID: %d, remaining space: %d.\n", counter, room.getRoomNumber(), (room.getCapacity() - room.getOccupancy()));
            counter ++;
        }
     } 
    
    
    //Static method for searching for students by name or room number 
    public static void searchStudent(int choice) {
        Scanner scanner = new Scanner(System.in);
        
            if (choice == 1) {
                System.out.println("\n------------------ \n" +
                                   "  Search by name \n" + 
                                   "------------------ \n");
                String searchQuery;
                System.out.print("Enter the student name: ");
                searchQuery = scanner.nextLine();
                for (Resident resident : residents) {
                    //Validate whether the name given is align with the resident's name
                    if (resident.getName().equalsIgnoreCase(searchQuery)) {
                        System.out.println("Student found: " + resident.getName() + " is staying in room " + resident.getRoomNumber());
                        return;
                    }
                }   
            }
            
            else {
                System.out.println("\n------------------------- \n" +
                                   "  Search by room number \n" + 
                                   "------------------------- \n");
                int searchQuery;
                System.out.print("Enter the room number: ");
                searchQuery = scanner.nextInt();
                for (Room room : rooms) {
                    //Validate whether the room number is same as the given number
                    if (room.getRoomNumber() == searchQuery) {
                        System.out.print("Room " + room.getRoomNumber() + " is occupied by: ");
                        Resident[] occupants = room.getOccupants();
                        for (Resident resident : occupants) {
                            System.out.printf("%s | ",resident.getName());
                        }
                        return;
                    }
                }
            }

        System.out.println("No results found");
        scanner.close();
    }
    
    //Static method for generating a report of room occupancy rates
    public static void generateOccupancyReport() {
        int totalRooms = rooms.length;
        int fullyOccupiedRooms = 0;
        int partiallyOccupiedRooms = 0;
        int emptyRooms = 0;

        for (Room room : rooms) {
            if (room.getOccupancy() == room.getCapacity()) {
                fullyOccupiedRooms++;
            } else if (room.getOccupancy() > 0) {
                partiallyOccupiedRooms++;
            } else {
                emptyRooms++;
            }
        }

        System.out.printf("Total Rooms: %d\n", totalRooms);
        System.out.printf("Fully Occupied Rooms: %d (%.2f%%)\n", fullyOccupiedRooms, (fullyOccupiedRooms / (double) totalRooms) * 100);
        System.out.printf("Partially Occupied Rooms: %d (%.2f%%)\n", partiallyOccupiedRooms, (partiallyOccupiedRooms / (double) totalRooms) * 100);
        System.out.printf("Empty Rooms: %d (%.2f%%)\n", emptyRooms, (emptyRooms / (double) totalRooms) * 100);
        System.out.println("----------------------------");
    }
}



