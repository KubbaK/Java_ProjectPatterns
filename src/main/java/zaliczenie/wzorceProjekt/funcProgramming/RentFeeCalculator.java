package zaliczenie.wzorceProjekt.funcProgramming;

@FunctionalInterface
public interface RentFeeCalculator {
    double calculateFee(double durationInDays, double baseRate);
}
