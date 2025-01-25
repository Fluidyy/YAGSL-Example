package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooter extends SubsystemBase {
    private SparkMax neo5 = new SparkMax(11, MotorType.kBrushless);
    private SparkMax neo6 = new SparkMax(12, MotorType.kBrushless);
    private PIDController pid = new PIDController(0.001, 0, 0);


    @Override
    public void periodic() {
        

    }

    public Command Shootercmd(double speed) {

        return new Command() {
            @Override
            public void initialize() {

            }

            @Override
            public void execute() {
                neo5.set(speed);
                neo6.set(speed);
            }

            @Override
            public void end(boolean interrupted) {

            }

            @Override
            public boolean isFinished() {   
                return pid.atSetpoint();
            }
        };
    }
}