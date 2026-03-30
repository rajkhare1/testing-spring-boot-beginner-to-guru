package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    @Test
    void processCreationForm() {
        //given
        Owner owner = new Owner(1L, "Raj", "Khare");
        given(ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%")).willThrow(new RuntimeException("boom"));

        //when
        assertThrows(RuntimeException.class, () -> ownerController.processCreationForm(owner, new BindingResult() {
            @Override
            public void rejectValue(String lastName, String notFound, String not_found) {

            }

            @Override
            public boolean hasErrors() {
                return false;
            }
        }));

        then(ownerService).should().findAllByLastNameLike("%"+ owner.getLastName() + "%");

    }
}