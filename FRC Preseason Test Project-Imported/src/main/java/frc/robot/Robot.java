// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.print.attribute.standard.JobHoldUntil;

import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator.Validity;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  
  private final int moduleID = 0;
  private final PneumaticsModuleType moduleType = PneumaticsModuleType.CTREPCM;
  private final int ex1ID = 3;
  private final int v1ID = 1;
  private final int ex2ID = 4;
  private final int v2ID = 5;

  private final int solonoid1ForwardID = 2;
  private final int solonoid2ForwardID = 5;
  private final int solonoid1ReverseID = 3;
  private final int solonoid2ReverseID = 4;

  private boolean solonoid1state = false;
  private boolean solonoid2state = false;
    // private final CANSparkMax m_test = new CANSparkMax(0, MotorType.kBrushless);
  private final Compressor m_compressor = new Compressor(moduleID, moduleType); //Need Module ID (?)
  
  private final DoubleSolenoid m_Solenoid1 = new DoubleSolenoid(
    
    moduleType, 
    solonoid1ForwardID, 
    solonoid1ReverseID
  );
  //  Need channel solenoid is on also Module ID (?)
  private final DoubleSolenoid m_Solenoid2 = new DoubleSolenoid( moduleType, solonoid2ForwardID,solonoid2ReverseID);

  // private final Solenoid ex1 = new Solenoid(moduleType, ex1ID);
  // private final Solenoid v1 = new Solenoid(moduleType, v1ID);
  // private final Solenoid ex2 = new Solenoid(moduleType, ex2ID);
  // private final Solenoid v2 = new Solenoid(moduleType, v2ID);

  // private final PWMSparkMax m_leftDrive = new PWMSparkMax(0);
  // private final PWMSparkMax m_rightDrive = new PWMSparkMax(1);
  // private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    // m_rightDrive.setInverted(true);

    //Should enable compressor on start
    

    // ex1.set(false);
    // v1.set(false);
    // ex2.set(false);
    // v2.set(false);

    // SmartDashboard.putBoolean("ex1", false);
    // SmartDashboard.putBoolean("ex2", false);
    // SmartDashboard.putBoolean("v1", false);
    // SmartDashboard.putBoolean("v2", false);

    solonoid1state = true;
    solonoid2state = false;

    if (solonoid1state){
      m_Solenoid1.set(Value.kForward);
    }
    else{
      m_Solenoid1.set(Value.kReverse);
    }
    if (solonoid2state){
      m_Solenoid2.set(Value.kForward);
    }
    else{
      m_Solenoid2.set(Value.kReverse);
    }



    m_compressor.enableDigital();

  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    // if (m_timer.get() < 2.0) {
    //   m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    // } else {
    //   m_robotDrive.stopMotor(); // stop robot
    // }
  }

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {
    
  }

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    // m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
    // m_test.set(m_stick.getY());
    
    //Toggles solenoid on button press
    // if (m_stick.getRawButtonPressed(1)){
    //   m_Solenoid1.set(Value.kForward);
    //   m_Solenoid2.set(Value.kReverse);

    // }
    // if (m_stick.getRawButtonPressed(2)){
    //   m_Solenoid1.set(Value.kReverse);
    //   m_Solenoid2.set(Value.kForward);
      
    // }
    // if (m_stick.getRawButtonPressed(3)){
    //   m_Solenoid1.set(Value.kOff);
    //   m_Solenoid2.set(Value.kOff);
    // }

    // ex1.set(SmartDashboard.getBoolean("ex1", false));
    // ex2.set(SmartDashboard.getBoolean("ex2", false));
    // v1.set(SmartDashboard.getBoolean("v1", false));
    // v2.set(SmartDashboard.getBoolean("v2", false));

    // SmartDashboard.putString("Solonoid1", m_Solenoid1.get().toString());
    // SmartDashboard.putString("Solonoid2", m_Solenoid2.get().toString());


    if ( m_stick.getRawButtonPressed(1)){
      solonoid1state = !solonoid1state;
    }
    if (m_stick.getRawButtonPressed(2)){
      solonoid2state = !solonoid2state;
    }

    

    if (solonoid1state){
      m_Solenoid1.set(Value.kForward);
    }
    else{
      m_Solenoid1.set(Value.kReverse);
    }
    if (solonoid2state){
      m_Solenoid2.set(Value.kForward);
    }
    else{
      m_Solenoid2.set(Value.kReverse);
    }


    SmartDashboard.putBoolean("Solenoid 1", solonoid1state);
    SmartDashboard.putBoolean("Solenoid 2", solonoid2state);
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
