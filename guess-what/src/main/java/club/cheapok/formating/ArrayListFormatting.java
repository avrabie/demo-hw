package club.cheapok.formating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;

public class ArrayListFormatting {

    public static void main(String[] args) {
        List<Integer> portInts = Arrays.asList(3, 5, 34, 21, 54, 2);
        System.out.println(portInts);
        System.out.println(portInts.toString());
        List<Port> ports = new ArrayList<>();
        ports.add(new Port("4"));
        ports.add(new Port("23"));
        ports.add(new Port("75"));
        ports.add(new Port("84"));
        System.out.println(ports.toString());
        DstPorts iaka = new DstPorts(ports);
        System.out.println(iaka);
    }

    @Data
    private static class Port {
        String port;

        public Port(String port) {
            this.port = port;
        }

        @Override
        public String toString() {
            return port;
        }
    }

    @Data
    public static class DstPorts {
        List<Port> ports;

        public DstPorts(List<Port> ports) {
            this.ports = ports;
        }
        @Override
        public String toString() {
            return ports.toString();
        }
    }

}
