import React, { useState, useContext } from 'react';
import './AccountSettings.css';
import { UserContext } from '../../contexts/UserContext';

const AccountSettings = () => {
    const [activeTab, setActiveTab] = useState('changePassword');
    const [isTwoFactorEnabled, setIsTwoFactorEnabled] = useState(false);
    const [oldPassword, setOldPassword] = useState('');
    const [newPassword, setNewPassword] = useState('');
    const [confirmNewPassword, setConfirmNewPassword] = useState('');
    const [deleteConfirmation, setDeleteConfirmation] = useState('');
    const { user, changePassword, deleteUser, error, loading, logout } = useContext(UserContext);

    const handleChangePassword = async (e) => {
        e.preventDefault();
        if (newPassword !== confirmNewPassword) {
            alert('Mật khẩu mới và xác nhận mật khẩu mới không khớp.');
            return;
        }
        if (user) {
            await changePassword(user.id, oldPassword, newPassword);
            if (!error) {
                alert('Đổi mật khẩu thành công.');
                setOldPassword('');
                setNewPassword('');
                setConfirmNewPassword('');
            } else {
                alert(error);
            }
        }
    };

    const handleDeleteAccount = async () => {
        if (deleteConfirmation === user.username) {
            await deleteUser(user.id);
            if (!error) {
                alert('Tài khoản đã được xoá.');
                logout();
            } else {
                alert(error);
            }
        } else {
            alert('Xác nhận xoá tài khoản không khớp.');
        }
    };

    return (
        <div>
            <div className="container mt-5">
                <h3>Tài khoản và bảo mật</h3>

                <ul className="nav nav-tabs" id="myTab" role="tablist">
                    <li className="nav-item nav-tab" role="presentation">
                        <button
                            className={`nav-link ${activeTab === 'changePassword' ? 'active' : ''}`}
                            id="changePassword-tab"
                            data-bs-toggle="tab"
                            role="tab"
                            onClick={() => setActiveTab('changePassword')}
                        >
                            Thay đổi mật khẩu
                        </button>
                    </li>
                    <li className="nav-item nav-tab" role="presentation">
                        <button
                            className={`nav-link ${activeTab === 'twoFactor' ? 'active' : ''}`}
                            id="twoFactor-tab"
                            data-bs-toggle="tab"
                            role="tab"
                            onClick={() => setActiveTab('twoFactor')}
                        >
                            Xác thực hai lớp
                        </button>
                    </li>
                    <li className="nav-item nav-tab" role="presentation">
                        <button
                            className={`nav-link ${activeTab === 'deleteAccount' ? 'active' : ''}`}
                            id="deleteAccount-tab"
                            data-bs-toggle="tab"
                            role="tab"
                            onClick={() => setActiveTab('deleteAccount')}
                        >
                            Xóa tài khoản
                        </button>
                    </li>
                </ul>

                <div className="tab-content" id="myTabContent">
                    {activeTab === 'changePassword' && (
                        <div className="tab-pane fade show active" id="changePassword" role="tabpanel">
                            <form onSubmit={handleChangePassword} className="mt-4">
                                <div className="mb-3">
                                    <label htmlFor="oldPassword" className="form-label">Mật khẩu cũ</label>
                                    <input
                                        type="password"
                                        className="form-control"
                                        id="oldPassword"
                                        name="oldPassword"
                                        value={oldPassword}
                                        onChange={(e) => setOldPassword(e.target.value)}
                                        required
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="newPassword" className="form-label">Mật khẩu mới</label>
                                    <input
                                        type="password"
                                        className="form-control"
                                        id="newPassword"
                                        name="newPassword"
                                        value={newPassword}
                                        onChange={(e) => setNewPassword(e.target.value)}
                                        required
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="confirmNewPassword" className="form-label">Xác nhận mật khẩu mới</label>
                                    <input
                                        type="password"
                                        className="form-control"
                                        id="confirmNewPassword"
                                        name="confirmNewPassword"
                                        value={confirmNewPassword}
                                        onChange={(e) => setConfirmNewPassword(e.target.value)}
                                        required
                                    />
                                </div>
                                <button type="submit" className="btn btn-primary" disabled={loading}>
                                    {loading ? 'Đang xử lý...' : 'Lưu thay đổi'}
                                </button>
                            </form>
                        </div>
                    )}

                    {activeTab === 'twoFactor' && (
                        <div className="tab-pane fade show active" id="twoFactor" role="tabpanel">
                            <div className="form-check form-switch mt-4">
                                <input
                                    className="form-check-input"
                                    type="checkbox"
                                    id="twoFactorToggle"
                                    checked={isTwoFactorEnabled}
                                    onChange={() => setIsTwoFactorEnabled(!isTwoFactorEnabled)}
                                />
                                <label className="form-check-label" htmlFor="twoFactorToggle">
                                    Bật xác thực hai lớp qua email?
                                </label>
                            </div>
                        </div>
                    )}

                    {activeTab === 'deleteAccount' && (
                        <div className="tab-pane fade show active" id="deleteAccount" role="tabpanel">
                            <div className="mt-4">
                                <p>Để xóa tài khoản của bạn, vui lòng nhập tên đăng nhập của bạn để xác nhận.</p>
                                <input
                                    type="text"
                                    className="form-control mb-3"
                                    placeholder="Tên đăng nhập"
                                    value={deleteConfirmation}
                                    onChange={(e) => setDeleteConfirmation(e.target.value)}
                                />
                                <button
                                    className="btn btn-danger"
                                    onClick={handleDeleteAccount}
                                    disabled={loading}
                                >
                                    {loading ? 'Đang xử lý...' : 'Xóa tài khoản'}
                                </button>
                            </div>
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
}

export default AccountSettings;
