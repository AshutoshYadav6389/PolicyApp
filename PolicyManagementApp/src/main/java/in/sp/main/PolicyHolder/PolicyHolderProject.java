package in.sp.main.PolicyHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PolicyHolder {
    private String policyId;
    private String name;
    private double investmentAmount;
    private int yearsInForce;

    // Constructor
    public PolicyHolder(String policyId, String name, double investmentAmount, int yearsInForce) {
        this.policyId = policyId;
        this.name = name;
        this.investmentAmount = investmentAmount;
        this.yearsInForce = yearsInForce;
    }

    // Getters and Setters
    public String getPolicyId() { return policyId; }
    public String getName() { return name; }
    public double getInvestmentAmount() { return investmentAmount; }
    public int getYearsInForce() { return yearsInForce; }

    public void setPolicyId(String policyId) { this.policyId = policyId; }
    public void setName(String name) { this.name = name; }
    public void setInvestmentAmount(double investmentAmount) { this.investmentAmount = investmentAmount; }
    public void setYearsInForce(int yearsInForce) { this.yearsInForce = yearsInForce; }

    @Override
    public String toString() {
        return "Policy ID: " + policyId +
                ", Name: " + name +
                ", Investment Amount: " + investmentAmount +
                ", Years In Force: " + yearsInForce;
    }
}

public class PolicyHolderProject {

    // Method 1: Calculate Maturity Value
    public static double calculateMaturityValue(double investmentAmount, int yearsInForce) {
        return investmentAmount * Math.pow(1.08, yearsInForce);  // 8% annual return
    }

    // Method 2: Find High-Value Policies (> 1,00,000)
    public static void findHighValuePolicies(List<PolicyHolder> list) {
        System.out.println("\n--- High Value Policies (Investment > 1,00,000) ---");
        boolean found = false;

        for (PolicyHolder p : list) {
            if (p.getInvestmentAmount() > 100000) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No high-value policies found.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<PolicyHolder> policyList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== Policy Holder Management App =====");
            System.out.println("1. Add Policy Holder");
            System.out.println("2. View All Policies");
            System.out.println("3. Calculate Maturity Value");
            System.out.println("4. Find High Value Policies (> 1,00,000)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Policy ID: ");
                    String id = sc.next();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Investment Amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Enter Years In Force: ");
                    int years = sc.nextInt();

                    policyList.add(new PolicyHolder(id, name, amount, years));
                    System.out.println("Policy Holder Added Successfully!");
                    break;

                case 2:
                    System.out.println("\n--- All Policy Holders ---");
                    for (PolicyHolder p : policyList) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("Enter Investment Amount: ");
                    double inv = sc.nextDouble();

                    System.out.print("Enter Years In Force: ");
                    int y = sc.nextInt();

                    double maturity = calculateMaturityValue(inv, y);
                    System.out.println("Maturity Value = " + maturity);
                    break;

                case 4:
                    findHighValuePolicies(policyList);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}