package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pivot extends SubsystemBase {
    private TalonFX talon1 = new TalonFX(30);
    private TalonFX talon2 = new TalonFX(31);
    private PIDController pid = new PIDController(0.05, 0, 0);


    @Override
    public void periodic() {
        SmartDashboard.putNumber("Boxpiv", talon1.getPosition().getValueAsDouble());  

    }
    public double setSetpoint(double setpoint){
        
        pid.setSetpoint(setpoint);
        double move = pid.calculate(talon1.getPosition().getValueAsDouble());
        return move;
        
       
        

    }

 

        public Command Pivotcmd(double setpoint){
    
        
            return new Command() {
                @Override
                public void initialize() {
                    // Initialization code, such as resetting encoders or PID controllers
                }
        
                @Override
                public void execute() {
                    double speed = setSetpoint(setpoint); // Assuming setpid() calculates the speed based on PID
                    talon1.set(speed);
                    talon2.set(-speed);
                }
        
                @Override
                public void end(boolean interrupted) {
                    talon1.set(0);
                    talon2.set(0); // Stop the motor when the command ends or is interrupted
                    //setSetpoint(0);
                    
    
                }
                
        
                @Override
                public boolean isFinished() {
                    return false;
                }
            };
    }
}

