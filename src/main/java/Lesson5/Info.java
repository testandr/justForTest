package Lesson5;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Info {

    public Info() {
    }

    String crm_url = "https://crm.geekbrains.space/";

    String user_login_part = "user/login";
    String project_part = "project";
    String create_part = "create";
    String contact_part = "contact";
    String expense_part = "expense-request";
    String slash = "/";
    String expenseFilterDatePartStart = "?grid%5Bcrm-expense-request-grid%5D=i%3D1%26p%3D25%26s%255Bname%255D%3D-1%26f%255BcreatedAt%255D%255Btype%255D%3D1%26f%255BcreatedAt%255D%255Bpart%255D%3Dvalue%26f%255BcreatedAt%255D%255Bvalue%255D%255Bstart%255D%3D";
    String expenseFilterDatePartBetween = "%26f%255BcreatedAt%255D%255Bvalue%255D%255Bend%255D%3D";
    String expenseFilterDatePartEnd = "%26c%3Dname1.description1.expName1.spendClass1.sumPlan1.sum1.type1.wsLabel1.division1.business_unit1.createdAt1.unid1.initiatorNode1%26v%3D__all__%26a%3Dgrid%26g%255BoriginalRoute%255D%3Dcrm_expense_request_index";



    String loginPage = crm_url + user_login_part;
    String projectPage = crm_url + project_part + slash;
    String createProjectPage = crm_url + project_part + slash + create_part + slash;
    String contactsPage = crm_url + contact_part + slash;
    String createContactPage = crm_url + contact_part + slash + create_part;
    String expenseRequestPage = crm_url + expense_part + slash;
    String createExpenseRequestPage = crm_url + expense_part + slash + create_part;



    String name = "Autotest5";
    String organization = "Alya";
    String primaryContactPerson = "Иванов Петр";
    String lastName = "testLastName1";
    String firstName = "testFirstName1";
    String job = "testJob";
    String appointmentText = "Description for expense request3";
    String requestedAmount = "10";
    String dateFrom = "2021-10-05";
    String dateTo = "2021-10-06";

    String expenseFilteredByDatePage = expenseRequestPage + expenseFilterDatePartStart + dateFrom + expenseFilterDatePartBetween + dateTo + expenseFilterDatePartEnd;

    public boolean checkIfElementWithTextIsPresent(List<WebElement> descriptions, String appointmentText){
        boolean status = false;
        for (int i = 0; i < descriptions.size(); i++){
            if (descriptions.get(i).getText().contains(appointmentText)){
                status = true;
            }
        }
        return status;
    }

}
