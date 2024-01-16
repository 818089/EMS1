//package com.maze.serviceTest;
//
//import java.io.IOException;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.maze.repository.EmployeeRepository;
//import com.maze.serviceImpl.ExcelService;
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//
//
//@ExtendWith(MockitoExtension.class)
//public class ExcelServiceTest {
//	
//	@Mock
//	private EmployeeRepository employeeRepository;
//	
//	@InjectMocks
//	private ExcelService excelService;
//	
//	 @Test
//	  public void testSave() throws IOException {
//	    // Arrange
//		 MultipartFile createMockMultipartFile() throws IOException {
//			    byte[] content = "mock file content".getBytes();
//			    return new MockMultipartFile("file", "filename.xlsx", "application/vnd.ms-excel", content);
//			}	    // Mock the behavior of the repository
//	    Mockito.when(employeeRepository.saveAll(Mockito.anyList())).thenReturn(null);
//
//	    // Act
//	    excelService.save(file);
//
//	    // Assert
//	    Mockito.verify(employeeRepository, Mockito.times(1)).saveAll(Mockito.anyList());
//	  }
//
//}
