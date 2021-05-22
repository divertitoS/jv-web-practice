package mate.controller.car;

import mate.lib.Injector;
import mate.service.CarService;
import mate.service.DriverService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDriverIntoTheCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private final CarService carService = (CarService) injector
            .getInstance(CarService.class);
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/cars/add-driver.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        carService.addDriverToCar(driverService.get(Long.valueOf(req.getParameter("driverId"))),
                carService.get(Long.valueOf(req.getParameter("carId"))));
    }
}