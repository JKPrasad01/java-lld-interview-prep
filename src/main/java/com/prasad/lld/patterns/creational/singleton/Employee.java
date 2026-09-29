package com.prasad.lld.patterns.creational.singleton;

public class Employee {

    // Private constructor:
    // Prevents other classes from creating objects using "new Employee()".
    // The only way to get an Employee object is through the getInstance() methods.
    private Employee() {
    }


    // ============================================================
    // 1. LAZY INITIALIZATION - NOT THREAD SAFE
    // ============================================================

    /*
     * LAZY INITIALIZATION:
     *
     * The object is NOT created when the class is loaded.
     * The object is created only when getInstance() is called
     * for the first time.
     *
     * Problem:
     * This implementation is NOT thread-safe.
     *
     * If two threads simultaneously check:
     *
     *     if (lazyInstance == null)
     *
     * both threads can see null and create two different objects.
     *
     * Example:
     *
     * Thread 1 -> lazyInstance == null -> creates Object A
     * Thread 2 -> lazyInstance == null -> creates Object B
     *
     * Therefore, multiple Singleton objects can be created.
     */

    private static Employee lazyInstance;

    public static Employee getInstance() {

        // Check whether the object has already been created
        if (lazyInstance == null) {

            // Create the object only when it is required
            lazyInstance = new Employee();
        }

        // Return the existing object
        return lazyInstance;
    }


    // ============================================================
    // 2. LAZY INITIALIZATION + SYNCHRONIZED
    //    THREAD SAFE
    // ============================================================

    /*
     * SYNCHRONIZED SINGLETON:
     *
     * synchronized allows only one thread at a time
     * to execute this method.
     *
     * Therefore, two threads cannot simultaneously create
     * the Singleton object.
     *
     * Example:
     *
     * Thread 1 -> enters method -> creates object
     * Thread 2 -> waits
     * Thread 1 -> exits method
     * Thread 2 -> enters method -> gets existing object
     *
     * Advantage:
     *     Simple and thread-safe.
     *
     * Disadvantage:
     *     Every call to getInstanceSynchronized() requires
     *     synchronization, even after the object has already
     *     been created.
     */

    public static synchronized Employee getInstanceSynchronized() {

        // Check whether the object has already been created
        if (lazyInstance == null) {

            // Create the Singleton object
            lazyInstance = new Employee();
        }

        // Return the Singleton object
        return lazyInstance;
    }


    // ============================================================
    // 3. DOUBLE-CHECKED LOCKING
    //    LAZY + THREAD SAFE
    // ============================================================

    /*
     * DOUBLE-CHECKED LOCKING:
     *
     * This approach performs TWO null checks.
     *
     * First check:
     *     Avoids synchronization if the object already exists.
     *
     * Second check:
     *     Ensures that another thread did not create the object
     *     while the current thread was waiting for the lock.
     *
     * Why volatile?
     *
     * volatile provides visibility between threads and prevents
     * unsafe instruction reordering during object creation.
     *
     * Flow:
     *
     * Thread 1 -> First check -> null
     *          -> enters synchronized block
     *          -> Second check -> null
     *          -> creates object
     *
     * Thread 2 -> First check -> null
     *          -> waits for lock
     *          -> Thread 1 creates object
     *          -> Thread 2 gets lock
     *          -> Second check -> NOT null
     *          -> returns existing object
     *
     * Once the object exists:
     *
     * Thread -> First check -> NOT null
     *        -> returns immediately
     *
     * Therefore, synchronization is avoided for normal calls
     * after the object has already been created.
     */

    private static volatile Employee doubleCheckInstance;

    public static Employee getInstanceDoubleCheck() {

        // First check:
        // If object already exists, no synchronization is required.
        if (doubleCheckInstance == null) {

            // Only one thread can enter this block at a time.
            synchronized (Employee.class) {

                // Second check:
                // Another thread may have created the object
                // while this thread was waiting for the lock.
                if (doubleCheckInstance == null) {

                    // Create the Singleton object
                    doubleCheckInstance = new Employee();
                }
            }
        }

        // Return the Singleton object
        return doubleCheckInstance;
    }


    // ============================================================
    // 4. EAGER INITIALIZATION
    //    THREAD SAFE
    // ============================================================

    /*
     * EAGER INITIALIZATION:
     *
     * The Singleton object is created when the class is
     * initialized by the JVM.
     *
     * It does NOT wait for getEagerInstance() to be called.
     *
     * Advantage:
     *     Very simple.
     *     Thread-safe because Java class initialization
     *     is guaranteed to be thread-safe.
     *
     * Disadvantage:
     *     The object is created even if the application
     *     never uses it.
     *
     * Therefore:
     *
     * Eager -> object created immediately
     * Lazy  -> object created only when needed
     */

    private static final Employee EAGER_INSTANCE = new Employee();

    public static Employee getEagerInstance() {

        // Return the already-created Singleton object
        return EAGER_INSTANCE;
    }
}