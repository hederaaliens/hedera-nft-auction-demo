import FooterLogo from './assets/footer_logo.svg'

const Footer = () => {
  const currentYear = new Date().getFullYear()
  return (
    <div className='flex justify-between p-5 mt-4 items-center font-thin'>
      <FooterLogo style={{ width: '12rem' }} />
      <p>® {currentYear} All Rights Reserved</p>
    </div>
  )
}

export default Footer
