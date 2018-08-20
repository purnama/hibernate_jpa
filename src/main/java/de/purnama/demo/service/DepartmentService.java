package de.purnama.demo.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.purnama.demo.model.Department;
import de.purnama.demo.model.Review;
import de.purnama.demo.repository.DepartmentRepository;
import de.purnama.demo.repository.ReviewRepository;

/**
 * @author Arthur Purnama (arthur@purnama.de)
 */
@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Iterable<Review> findAllReview(Long id) {
        return reviewRepository.findByDepartment(departmentRepository.findById(id).get());
    }

    public Iterable<Review> findAllReviewByUniqueName(String id) {
        return reviewRepository.findByDepartment(departmentRepository.findByUniqueName(id));
    }

    public Department create(Department department) {
        Department newDepartment = new Department();
        newDepartment.setAddress(department.getAddress());
        newDepartment.setAddressAdd(department.getAddressAdd());
        newDepartment.setContent(department.getContent());
        newDepartment.setDescription(department.getDescription());
        newDepartment.setEmail(department.getEmail());
        newDepartment.setLatitude(department.getLatitude());
        newDepartment.setLongitude(department.getLongitude());
        newDepartment.setName(department.getName());
        newDepartment.setOpeningHour(department.getOpeningHour());
        newDepartment.setState(department.getState());
        newDepartment.setTelephone(department.getTelephone());
        newDepartment.setUniqueName(department.getUniqueName());
        newDepartment.setZipCode(department.getZipCode());
        return departmentRepository.save(newDepartment);
    }

    public Department update(String id, Department department) {
        Department oldDepartment;
        try {
            oldDepartment = departmentRepository.findById(Long.parseLong(id)).get();
        }catch(NumberFormatException e){
            oldDepartment = departmentRepository.findByUniqueName(id);
        }
        oldDepartment.setAddress(department.getAddress());
        oldDepartment.setAddressAdd(department.getAddressAdd());
        oldDepartment.setContent(department.getContent());
        oldDepartment.setDescription(department.getDescription());
        oldDepartment.setEmail(department.getEmail());
        oldDepartment.setLatitude(department.getLatitude());
        oldDepartment.setLongitude(department.getLongitude());
        oldDepartment.setName(department.getName());
        oldDepartment.setOpeningHour(department.getOpeningHour());
        oldDepartment.setState(department.getState());
        oldDepartment.setTelephone(department.getTelephone());
        oldDepartment.setUniqueName(department.getUniqueName());
        oldDepartment.setZipCode(department.getZipCode());
        return departmentRepository.save(oldDepartment);
    }

    public Department delete(String id){
        Department oldDepartment;
        try {
            oldDepartment = departmentRepository.findById(Long.parseLong(id)).get();
        }catch(NumberFormatException e){
            oldDepartment = departmentRepository.findByUniqueName(id);
        }
        departmentRepository.delete(oldDepartment);
        return oldDepartment;
    }

    public Review saveReview(Long id, Review departmentReview, Principal principal) {
        //departmentReview.setUser(userRepository.findByUsername(principal.getName()));
        departmentReview.setDepartment(departmentRepository.findById(id).get());
        return reviewRepository.save(departmentReview);
    }
}
