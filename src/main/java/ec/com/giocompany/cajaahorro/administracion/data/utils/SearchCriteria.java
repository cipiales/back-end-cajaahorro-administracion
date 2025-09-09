package ec.com.giocompany.cajaahorro.administracion.data.utils;

import ec.com.giocompany.cajaahorro.administracion.model.pojo.Cuenta;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Socio;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.LinkedList;
import java.util.List;

public class SearchCriteria<Product> implements Specification<Product> {

    private final List<SearchStatement> list = new LinkedList<>();

    public void add(SearchStatement criteria) {
        list.add(criteria);
    }

    /*@Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new LinkedList<>();

        //Join<Cuenta, Socio> socioJoin = root.join("socio"); // socio debe ser una relación en Cuenta
        //Predicate predicate = cb.equal(socioJoin.get("cedulaIdentidad"), value);

        for (SearchStatement criteria : list) {
            if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(builder.greaterThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                predicates.add(builder.lessThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(builder.notEqual(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue().toString().toLowerCase() + "%"));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }*/
    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new LinkedList<>();

        for (SearchStatement criteria : list) {
            Path<?> path = getPath(root, criteria.getKey());

            switch (criteria.getOperation()) {
                case GREATER_THAN:
                    predicates.add(builder.greaterThan(path.as(String.class), criteria.getValue().toString()));
                    break;
                case LESS_THAN:
                    predicates.add(builder.lessThan(path.as(String.class), criteria.getValue().toString()));
                    break;
                case GREATER_THAN_EQUAL:
                    predicates.add(builder.greaterThanOrEqualTo(path.as(String.class), criteria.getValue().toString()));
                    break;
                case LESS_THAN_EQUAL:
                    predicates.add(builder.lessThanOrEqualTo(path.as(String.class), criteria.getValue().toString()));
                    break;
                case NOT_EQUAL:
                    predicates.add(builder.notEqual(path, criteria.getValue()));
                    break;
                case EQUAL:
                    predicates.add(builder.equal(path, criteria.getValue()));
                    break;
                case MATCH:
                    predicates.add(builder.like(builder.lower(path.as(String.class)),
                            "%" + criteria.getValue().toString().toLowerCase() + "%"));
                    break;
                case MATCH_END:
                    predicates.add(builder.like(builder.lower(path.as(String.class)),
                            criteria.getValue().toString().toLowerCase() + "%"));
                    break;
            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }



    /*private Path<?> getPath(From<?, ?> root, String key) {
        String[] parts = key.split("\\.");
        Path<?> path = root;
        for (String part : parts) {
            path = (path instanceof Root) ? ((Root<?>) path).get(part) : ((From<?, ?>) path).get(part);
        }
        return path;
    }*/

    @SuppressWarnings("unchecked")
    private Path<?> getPath(From<?, ?> root, String key) {
        String[] parts = key.split("\\.");
        Path<?> path = root;

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];

            if (i < parts.length - 1) {
                // ⚠️ hacemos join SOLO si no es el último elemento
                path = ((From<?, ?>) path).join(part, JoinType.LEFT);
            } else {
                // último elemento: solo get()
                path = path.get(part);
            }
        }

        return path;
    }
}