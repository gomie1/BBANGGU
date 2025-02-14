import { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { Header } from '../../../components/owner/editprofile/Header';
import { SubmitButton } from '../../../common/form/SubmitButton';
import BottomNavigation from '../../../components/owner/navigations/BottomNavigations/BottomNavigation';
import { IoTrashOutline } from 'react-icons/io5';

interface SettlementInfo {
  settlementId: number;
  bankName: string;
  accountHolderName: string;
  accountNumber: string;
  emailForTaxInvoice: string;
  businessLicenseFileUrl: string | null;
}

export function EditSettlement() {
  const location = useLocation();
  const navigate = useNavigate();
  const settlementInfo = location.state?.settlementInfo;

  const [formData, setFormData] = useState({
    bankName: '',
    accountHolderName: '',
    accountNumber: '',
    emailForTaxInvoice: '',
    businessLicenseFileUrl: null as string | null
  });

  useEffect(() => {
    if (settlementInfo) {
      setFormData({
        bankName: settlementInfo.bankName,
        accountHolderName: settlementInfo.accountHolderName,
        accountNumber: settlementInfo.accountNumber,
        emailForTaxInvoice: settlementInfo.emailForTaxInvoice,
        businessLicenseFileUrl: settlementInfo.businessLicenseFileUrl
      });
    }
  }, [settlementInfo]);

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    // TODO: 정산 정보 수정 API 호출
    navigate('/owner/mypage');
  };

  const inputClassName = "w-full px-4 py-3 rounded-[8px] border border-[#EFEFEF] placeholder-[#8E8E8E] focus:outline-none focus:border-[#FF9B50]";

  return (
    <div className="min-h-screen bg-white pb-20">
      <Header title="거래 및 정산 정보" />
      
      <form onSubmit={handleSubmit} className="space-y-6 p-4">
        <div className="space-y-2">
          <label className="block text-sm">
            은행명
            <span className="text-red-500 ml-1">*</span>
          </label>
          <input
            type="text"
            name="bankName"
            value={formData.bankName}
            onChange={handleInputChange}
            className={inputClassName}
          />
        </div>

        <div className="space-y-2">
          <label className="block text-sm">
            예금주
            <span className="text-red-500 ml-1">*</span>
          </label>
          <input
            type="text"
            name="accountHolderName"
            value={formData.accountHolderName}
            onChange={handleInputChange}
            className={inputClassName}
          />
        </div>

        <div className="space-y-2">
          <label className="block text-sm">
            계좌번호
            <span className="text-red-500 ml-1">*</span>
          </label>
          <input
            type="text"
            name="accountNumber"
            value={formData.accountNumber}
            onChange={handleInputChange}
            className={inputClassName}
          />
        </div>

        <div className="space-y-2">
          <label className="block text-sm">
            세금계산서 발행 이메일
            <span className="text-red-500 ml-1">*</span>
          </label>
          <input
            type="email"
            name="emailForTaxInvoice"
            value={formData.emailForTaxInvoice}
            onChange={handleInputChange}
            className={inputClassName}
          />
        </div>

        <SubmitButton
          text="수정"
          className="mt-8"
        />
      </form>

      <BottomNavigation />
    </div>
  );
}

export default EditSettlement;