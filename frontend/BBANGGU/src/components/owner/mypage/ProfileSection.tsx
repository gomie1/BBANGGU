import { Link } from 'react-router-dom';
import { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '../../../store';
import { fetchUserInfo } from '../../../store/slices/userSlice';

export function ProfileSection() {
  const dispatch = useDispatch();
  const userInfo = useSelector((state: RootState) => state.user.userInfo);
  
  useEffect(() => {
    if (!userInfo) {
      const storedUserInfo = localStorage.getItem('userInfo');
      if (storedUserInfo) {
        dispatch(fetchUserInfo(JSON.parse(storedUserInfo)));  // Redux 상태 복원
      }
    }
  }, [dispatch, userInfo]);

  const imgBaseUrl = import.meta.env.VITE_IMAGE_BASE_URL;

  return (
    <div className="px-6 py-6">
      <div className="flex items-center space-x-4">
        <img
          src={
            userInfo?.profileImageUrl ? `${imgBaseUrl}${userInfo.profileImageUrl}` : `${imgBaseUrl}/uploads/bakery19.jpeg`
          }
          alt="Profile"
          className="w-[80px] h-[80px] rounded-full object-cover bg-gray-100"
        />
        <div>
          <h2 className="text-lg font-semibold">
            {userInfo?.name}
            <span className="text-gray-600 font-normal ml-1">사장님</span>
          </h2>
          <p className="text-gray-600 text-sm">오늘도 빵과 함께 할기찬 하루 보내세요~</p>
        </div>
      </div>

      <div className="flex gap-3 mt-4">
        <Link 
          to="/owner/profile/edit"
          state={{ userInfo: {
            name: userInfo?.name,
            email: userInfo?.email,
            phone: userInfo?.phone,
            profileImageUrl: userInfo?.profileImageUrl
          }}}
          className="flex-1 py-2.5 text-center rounded-xl bg-[#FF9B50] text-white font-medium"
        >
          회원 정보 수정
        </Link>
        <Link 
          to="/owner/store/edit"
          className="flex-1 py-2.5 text-center rounded-xl border border-[#FF9B50] text-[#FF9B50] font-medium"
        >
          가게 정보 수정
        </Link>
      </div>
    </div>
  );
}
