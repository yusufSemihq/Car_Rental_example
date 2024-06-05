import java.util.ArrayList;
import java.util.List;

// Araç sınıfı
class Car {
    private String brand;
    private String model;
    private int year;
    private boolean isAvailable;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.isAvailable = true;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

// Kiralama işlemleri sınıfı
class RentalService {
    private List<Car> cars;

    public RentalService() {
        cars = new ArrayList<>();
        // Örnek araçlar ekleyelim
        cars.add(new Car("Toyota", "Corolla", 2018));
        cars.add(new Car("Honda", "Civic", 2020));
        cars.add(new Car("Ford", "Focus", 2019));
        cars.add(new Car("Audi", "A4", 2021));
        cars.add(new Car("Bmw", "X5", 2022));
        cars.add(new Car("Ford", "Mercedes-Benz C200 4Matic AMG Hybrid", 2023));
    }

    public List<Car> listAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public void rentCar(int index) {
        if (index >= 0 && index < cars.size()) {
            Car car = cars.get(index);
            if (car.isAvailable()) {
                car.setAvailable(false);
                System.out.println("Aracı kiraladınız: " + car.getBrand() + " " + car.getModel());
            } else {
                System.out.println("Seçtiğiniz araç şu anda kiralanamaz.");
            }
        } else {
            System.out.println("Geçersiz araç indeksi.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();

        // Mevcut araçları listele
        List<Car> availableCars = rentalService.listAvailableCars();
        System.out.println("Mevcut Araçlar:");
        for (int i = 0; i < availableCars.size(); i++) {
            Car car = availableCars.get(i);
            System.out.println((i + 1) + ". " + car.getBrand() + " " + car.getModel() + " - " + car.getYear());
        }

        // Araç kiralama
        rentalService.rentCar(0);
    }
}
