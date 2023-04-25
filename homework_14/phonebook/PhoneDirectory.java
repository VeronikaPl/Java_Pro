package phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneDirectory {
    private final List<Record> recordList;

    public PhoneDirectory() {
        this.recordList = new ArrayList<>();
    }

    public void add(Record record) {
        recordList.add(record);
    }

    public Record find(String name) {
        Objects.requireNonNull(name);
        for (Record record : recordList) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        Objects.requireNonNull(name);
        List<Record> foundRecord = new ArrayList<>();
        for (Record record : recordList) {
            if (record.getName().equals(name)) {
                foundRecord.add(record);
            }
        }
        return foundRecord.isEmpty() ? null : foundRecord;
    }
}
