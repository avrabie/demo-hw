package club.cheaok.services;

public interface ServiceListener {
    void onSuccess(Service service);
    void onFailure(Service service);
}
