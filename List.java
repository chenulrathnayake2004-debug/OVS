package Q4;


public class List {
    private int maxSize;
    private int position;
    private Student[] ListEntry;

    List(int size) {
        maxSize = size;
        ListEntry = new Student[maxSize];
        position = -1;
    }

    boolean IsListEmpty() {
        return (position == -1);
    }
    boolean IsListFull() {
        return (position == maxSize-1);
    }
    int ListSize() {
        return (position+1);
    }
    void InsertLast(Student x) {
        if(IsListFull())
            System.out.println("Attempt to insert at the end of a full list");
        else
            ListEntry[++position] = x;

    }
    void InsertList(int p,Student element) {
        int i ;
        if(IsListFull())
            System.out.println("Attempt to insert an entry into a full list");
        else if(p<0 || p>ListSize())
            System.out.println("attempt to insert a position not in the list");
        else {
            for (i=ListSize(); i>p;i--)
                ListEntry[i] = ListEntry[i-1];
            ListEntry[p] = element;
            position++;
        }
    }
    Student DeleteList(int p) {
        Student element;
        int i;
        if(IsListEmpty())
            System.out.println("attempt to insert a position not in the list");
        else if(p<0 || p>=ListSize())
            System.out.println("attempt to delete a position not in the list");
        else {
            element = ListEntry[p];
            for (i=p;i<ListSize()-1;i++)
                ListEntry[i] = ListEntry[i+1];
            position--;
            return element;
        }
        return null;
    }
    Student RetrieveList(int p) {
        Student element;
        int i;
        if(IsListEmpty()) {
            System.out.println("Attempt to retrieve an entry from an empty list");
            return null;
        }
        else if(p<0 || p>=ListSize()) {
            System.out.println("attempt to retrieve an entry at a position not in the list");
            return null;
        }
        else {
            element = ListEntry[p];
            return element;
        }
    }
    void ReplaceList (int p, Student x){
        if (IsListEmpty())
            System.out.println("Attempt to replace an entry of an empty list");
        else if (p < 0 || p >= ListSize())
            System.out.println("attempt to replace an entry at a position not in the list");
        else
            ListEntry[p] = x;
    }

    void TraverselList()
    {
        int i;
        for (i=0; i<position+1; i++)
            System.out.println(ListEntry[i]);
    }
    public void findHighestMarks() {
        if (IsListEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Student highest = ListEntry[0];
        for (int i = 1; i < ListSize(); i++) {
            if (ListEntry[i].marks > highest.marks) {
                highest = ListEntry[i];
            }
        }
        System.out.println("Student with the highest marks: " + highest.name
                + " (" + highest.marks + " marks)");
    }
    public void findShortestTime() {
        if (IsListEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Student fastest = ListEntry[0];
        for (int i = 1; i < ListSize(); i++) {
            if (ListEntry[i].time < fastest.time) {
                fastest = ListEntry[i];
            }
        }
        System.out.println("Student who submitted in the shortest time: " +
                fastest.name + " (" + fastest.time + " hours)");
    }
    public void displayPerformanceIndex() {
        if (IsListEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("--- Performance Index of Each Student ---");
        for (int i = 0; i < ListSize(); i++) {
            Student s = ListEntry[i];
            // Using double casting to handle decimal division precisely
            double index = (double) s.marks / s.time;
            System.out.printf("%s: %.2f\n", s.name, index);
        }
    }
    public void findBestPerformer() {
        if (IsListEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Student bestStudent = ListEntry[0];
        double highestIndex = (double) ListEntry[0].marks /
                ListEntry[0].time;
        for (int i = 1; i < ListSize(); i++) {
            Student s = ListEntry[i];
            double currentIndex = (double) s.marks / s.time;

            if (currentIndex > highestIndex) {
                highestIndex = currentIndex;
                bestStudent = s;
            }
        }
        System.out.printf("Best-performing student: %s with a Performance Index of %.2f\n", bestStudent.name, highestIndex);
    }


    public static void main(String[] args) {
        List list = new List(10);

        list.InsertLast(new Student("Nimal",78,5));
        list.InsertLast(new Student("Kavindu",91,8));
        list.InsertLast(new Student("Dilsha",69,4));
        list.InsertLast(new Student("Pasindu",88,6));
        list.InsertLast(new Student("Shehani",95,9));

        System.out.println("--- Question a ---");
        list.findHighestMarks();
        System.out.println();

        System.out.println("--- Question b ---");
        list.findShortestTime();
        System.out.println();

        System.out.println("--- Question c ---");
        list.displayPerformanceIndex();
        System.out.println();

        System.out.println("--- Question d ---");
        list.findBestPerformer();

    }
}
