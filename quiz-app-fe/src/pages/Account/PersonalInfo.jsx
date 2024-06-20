import React, { useState, useContext, useEffect } from 'react';
import { UserContext } from '../../contexts/UserContext';

const PersonalInfo = () => {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [avatar, setAvatar] = useState(null);
  const [usernameExists, setUsernameExists] = useState(false);
  const [emailExists, setEmailExists] = useState(false);
  const { user, updateUserDetails, existsByUsername, existsByEmail, error, loading } = useContext(UserContext);

  useEffect(() => {
    if (user) {
      setUsername(user.username);
      setEmail(user.email);
    }
  }, [user]);

  const handleUsernameChange = async (e) => {
    const newUsername = e.target.value;
    setUsername(newUsername);
    if (newUsername !== user.username) {
      const exists = await existsByUsername(newUsername);
      setUsernameExists(exists);
    } else {
      setUsernameExists(false);
    }
  };

  const handleEmailChange = async (e) => {
    const newEmail = e.target.value;
    setEmail(newEmail);
    if (newEmail !== user.email) {
      const exists = await existsByEmail(newEmail);
      setEmailExists(exists);
    } else {
      setEmailExists(false);
    }
  };

  const handleAvatarChange = (e) => {
    setAvatar(e.target.files[0]);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (usernameExists) {
      alert('Tên đăng nhập đã tồn tại.');
      return;
    }
    if (emailExists) {
      alert('Email đã tồn tại.');
      return;
    }

    const formData = new FormData();
    formData.append('username', username);
    formData.append('email', email);
    if (avatar) {
      formData.append('avatar', avatar);
    }

    if (user) {
      await updateUserDetails(user.id, formData);
      if (!error) {
        alert('Thông tin cá nhân đã được cập nhật.');
      } else {
        alert(error);
      }
    }
  };

  return (
    <div className="container ps-4 pe-4 mt-5">
      <h3 className='mb-4'>Thông tin cá nhân</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="username" className="form-label">Tên đăng nhập</label>
          <input
            type="text"
            className={`form-control ${usernameExists ? 'is-invalid' : ''}`}
            id="username"
            value={username}
            onChange={handleUsernameChange}
            required
          />
          {usernameExists && <div className="invalid-feedback">Tên đăng nhập đã tồn tại.</div>}
        </div>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">Email</label>
          <input
            type="email"
            className={`form-control ${emailExists ? 'is-invalid' : ''}`}
            id="email"
            value={email}
            onChange={handleEmailChange}
            required
          />
          {emailExists && <div className="invalid-feedback">Email đã tồn tại.</div>}
        </div>
        <div className="mb-3">
          <label htmlFor="avatar" className="form-label">Avatar</label>
          <input
            type="file"
            className="form-control"
            id="avatar"
            name="avatar"
            onChange={handleAvatarChange}
          />
        </div>
        <button type="submit" className="btn btn-primary" disabled={loading}>
          {loading ? 'Đang xử lý...' : 'Lưu thay đổi'}
        </button>
      </form>
    </div>
  );
};

export default PersonalInfo;
