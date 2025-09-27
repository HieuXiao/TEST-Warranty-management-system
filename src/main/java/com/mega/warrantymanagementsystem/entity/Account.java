package com.mega.warrantymanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity//đánh dấu là 1 thực thể
@Data//tự động sinh getter setter
@Table  (name = "accounts") //tên bảng trong DB
@AllArgsConstructor//tự động sinh constructor có tham số
@NoArgsConstructor//tự động sinh constructor không tham số
public class Account implements UserDetails {

    @Id
    @Pattern(
            regexp = "^(AD|ST|SS|ES)[0-9]{6}$",
            message = "ID must follow the format ADxxxxxx, STxxxxxx, SSxxxxxx, or ESxxxxxx, where xxxxxx are digits."
    )//AD000001, ST000001, SS000001, ES000001
    @Column(name = "accountId", nullable = false, length = 10, unique = true)//unique: không được trùng
    @NotEmpty(message = "ID cannot be empty!")//không được để trống
    private String accountId;

    @Column(name = "username", nullable = false, length = 100)
    @NotEmpty(message = "Username cannot be empty!")
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    @NotEmpty(message = "Password cannot be empty!")
    private String password;

    @Column(name = "full_name", nullable = false, length = 100)
    @NotEmpty(message = "Full name cannot be empty!")
    private String fullName;

    @Column(name = "gender", nullable = false)//true = Male, false = Female
    private boolean gender;

    @Email
    private String email;

    @Pattern(
            regexp = "^(0|\\+84)(3[2-9]|5[2|6-9]|7[0|6-9]|8[1-9]|9[0-9])[0-9]{7}$",
            message = "Phone invalid!"
    )
    @Column(name = "phone", nullable = false)
    @NotEmpty(message = "phone cannot be empty!")
    private String phone;

    @Column(name = "role_name", nullable = false, length = 50)
    @NotEmpty(message = "Role name cannot be empty!")
    private String roleName;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
