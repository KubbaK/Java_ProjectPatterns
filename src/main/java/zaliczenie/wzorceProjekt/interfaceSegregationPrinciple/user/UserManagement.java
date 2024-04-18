package zaliczenie.wzorceProjekt.interfaceSegregationPrinciple.user;

//Tydzień 8, Zasada segregacji interfejsów
public interface UserManagement {
    void addUser();
    void removeUser();
    void updateUser();
    void getUserInfo();
    void changePassword();
    void assignRole();
    void resetPassword();
}

interface BasicUserOperations {
    void addUser();
    void removeUser();
    void updateUser();
    void getUserInfo();
}

interface UserPasswordOperations {
    void changePassword();
    void resetPassword();
}

interface UserRoleManagement {
    void assignRole();
}
//Koniec Tydzień 8, Zasada segregacji interfejsów