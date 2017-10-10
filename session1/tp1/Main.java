package session1.tp1;

public class Main {
    public static void main(String[] args){
        test(new FabriqueFile<String>());
    }

    private static void test(IFabriqueFile fabrique){
        IFile<String> file = fabrique.creerFile();

        System.out.println("Count = " + file.count());
        file.add("1");
        System.out.println("Count = " + file.count());
        file.add("2");
        System.out.println("Count = " + file.count());
        file.add("3");
        System.out.println("Count = " + file.count());
        file.add("4");

        System.out.println(file.isEmpty() ? "La file est vide." : "La file n'est pas vide");
        System.out.println("1 : " + file.getAndRemove());
        System.out.println("2 : " + file.getAndRemove());
        System.out.println("3 : " + file.getAndRemove());
        System.out.println("4 : " + file.getAndRemove());
        System.out.println("5 : " + file.getAndRemove());
        System.out.println("Count = " + file.count());
        System.out.println(file.isEmpty() ? "La file est vide." : "La file n'est pas vide");
    }
}
