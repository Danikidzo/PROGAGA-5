package utility;

import data.*;

import java.util.*;

public class CollectionManager {
    private final HashSet<Long> hashSetId = new HashSet<>();
    private Long idIter = 1L;
    private TreeSet<HumanBeing> humanBeingCollection = new TreeSet<>();
    private Date creationDate = new Date();

    public void initialiseData(TreeSet<HumanBeing> treeSet) {
        this.humanBeingCollection = treeSet;
        for (HumanBeing humanBeing : humanBeingCollection) {
            hashSetId.add(humanBeing.getId());
        }
    }
    public int size() {
        return humanBeingCollection.size();
    }
    public boolean removeIdIfMatchArg(Long longArg) {
        return humanBeingCollection.removeIf(x -> x.getId() == longArg);
    }
    public Class<? extends TreeSet> getClassCollection() {
        return humanBeingCollection.getClass();
    }
    public TreeSet<HumanBeing> getHumanBeingCollection() {
        return humanBeingCollection;
    }


    public long countLessThanImpactSpeed(double impactSpeed) {
        return this.humanBeingCollection.stream().filter(e -> e.getImpactSpeed() < impactSpeed).count();
    }

  //  public double averageImpactSpeed(double impactSpeed) {
  //      return  this.humanBeingCollection.stream().
  //  }

    public void removeId(Long id) {
        hashSetId.remove(id);
    }
    public boolean isEmpty() {
        return humanBeingCollection.isEmpty();
    }

    public void clear() {
        hashSetId.clear();
        humanBeingCollection.clear();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Long getNewID() {
        idIter = 1L;
        while (hashSetId.contains(idIter)) {
            idIter++;
        }
        return idIter;
    }

    public boolean removeByID(Long id) {
        if (humanBeingCollection.stream().anyMatch(x -> x.getId()==id)) {
            HumanBeing humanBeing = humanBeingCollection.stream().filter(x -> x.getId()==id).findAny().get();
            hashSetId.remove(humanBeing.getId());
            humanBeingCollection.remove(humanBeing);
            removeId(id);
            return true;
        }
        return false;
    }

    public void add(HumanBeing humanBeing) {
        humanBeing.setId(getNewID());
        hashSetId.add(humanBeing.getId());
        humanBeingCollection.add(humanBeing);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (HumanBeing i : humanBeingCollection) {
            sb.append('\n').append(i.toString()).append('\n');
        }
        sb.append(']');

        return sb.toString();
    }


    public boolean isHaveId(Long id) {
        return humanBeingCollection.stream().anyMatch((x -> x.getId() == id));
    }
}
